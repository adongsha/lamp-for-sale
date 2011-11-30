package com.lamp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.lamp.model.Lamp;
import com.lamp.service.LampService;

public class AddLampAction extends SuperAction {
	LampService ls;
	
    @Resource
	public void setLs(LampService ls) {
		this.ls = ls;
	}

	// images用来封装上面的图片
	private List<File> images;
	// imagesFileName用来用来封装上传图片的图片名
	private List<String> imagesFileName;
	// savePath用来获得图片的保存目录
	private String savePath;

	public List<File> getImages() {
		return images;
	}

	public void setImages(List<File> images) {
		this.images = images;
	}

	public List<String> getImagesFileName() {
		return imagesFileName;
	}

	public void setImagesFileName(List<String> imagesFileName) {
		this.imagesFileName = imagesFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void uploadImages() throws IOException {
		// 取得用來上傳的文件的数组
		List<File> files = getImages();
		// 循环每个上传的文件
		for (int i = 0; i < files.size(); i++) {
			// 创建文件输入流
			InputStream is = new FileInputStream(files.get(i));
			// 设置上传文件目录
			String uploadPath = ServletActionContext.getServletContext()
					.getRealPath(getSavePath());
			// 设置目标文件
			File toFile = new File(uploadPath, getImagesFileName().get(i));
			// 输出流
			OutputStream os = new FileOutputStream(toFile);
			// 设置缓存
			byte[] buffer = new byte[1024];
			int length = 0;
			// 读取file[i]文件输出到toFile文件中
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			// 关闭输入流
			is.close();
			// 关闭输出流
			os.close();
		}
	}

	/**
	 * 插入圖片
	 * 
	 * @throws IOException
	 */
	public void addLamp(int lampId, String lampName, double price,
			String origin, String material, String process, String weight,
			String prictureImage1, String prictureImage2,
			String prictureImage3, String prictureImage4, String lampDescription)
			throws IOException {
		Lamp lamp = new Lamp();
		lamp.setLampId(lampId);
		lamp.setLampName(lampName);
		lamp.setPrice(price);
		lamp.setOrigin(origin);
		lamp.setLampDescription(lampDescription);
		lamp.setMaterial(material);
		lamp.setProcess(process);
		lamp.setWeight(weight);
		lamp.setPrictureImage1(prictureImage1);
		lamp.setPrictureImage2(prictureImage2);
		lamp.setPrictureImage3(prictureImage3);
		lamp.setPrictureImage4(prictureImage4);
		this.uploadImages();
        ls.addLamp(lamp);
	}

}
