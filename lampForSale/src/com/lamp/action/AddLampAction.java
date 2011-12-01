package com.lamp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.model.Lamp;
import com.lamp.service.LampService;

@Component("AddLampAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RemoteProxy(name = "addLampAction")
public class AddLampAction extends SuperAction {
	LampService lampService;

	@Resource
	public void setLampService(LampService lampService) {
		this.lampService = lampService;
	}

	private String isbn;
	private String lampName;
	private String origin;
	private double price;
	private String weight;
	private String process;
	private String material;
	private String lampDescription;
	List<String> pathList = new ArrayList<String>();

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
		System.out.println("uploadImages");
		// 取得用來上傳的文件的数组
		List<File> files = getImages();
		// 循环每个上传的文件
		for (int i = 0; i < files.size(); i++) {
			// 创建文件输入流
			InputStream is = new FileInputStream(files.get(i));
			// 设置上传文件目录
			String uploadPath = ServletActionContext.getServletContext()
					.getRealPath("/images/lampImages");
			System.out.println("uploadPath-->"+uploadPath);
			// 设置目标文件
			File toFile = new File(uploadPath, getImagesFileName().get(i));
			pathList.add(getImagesFileName().get(i));
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
	public String execute()
			throws IOException {
		System.out.println("开始！！!!!");
		this.uploadImages();
		Lamp lamp = new Lamp();
		lamp.setIsbn(getIsbn());
		System.out.println(lamp.getIsbn());
		lamp.setLampName(lampName);
		lamp.setPrice(price);
		lamp.setOrigin(origin);
		lamp.setLampDescription(lampDescription);
		lamp.setMaterial(material);
		lamp.setProcess(process);
		lamp.setWeight(weight);
		System.out.println(lamp.getWeight());
		lamp.setPrictureImage1(pathList.get(0));
		System.out.println(pathList.get(0));
		if(pathList.size() >= 2){
		lamp.setPrictureImage2(pathList.get(1));
		}else{
			lamp.setPrictureImage2(null);
		}
		if(pathList.size() >= 3){
			lamp.setPrictureImage3(pathList.get(2));
		}else{
			lamp.setPrictureImage3(null);
		}
		if(pathList.size() >= 4){
			lamp.setPrictureImage4(pathList.get(3));
		}else {
			lamp.setPrictureImage4(null);
		}
		lampService.addLamp(lamp);
		return SUCCESS;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLampName() {
		return lampName;
	}

	public void setLampName(String lampName) {
		this.lampName = lampName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getLampDescription() {
		return lampDescription;
	}

	public void setLampDescription(String lampDescription) {
		this.lampDescription = lampDescription;
	}

	public LampService getLampService() {
		return lampService;
	}

}
