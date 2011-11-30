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

	// images������װ�����ͼƬ
	private List<File> images;
	// imagesFileName����������װ�ϴ�ͼƬ��ͼƬ��
	private List<String> imagesFileName;
	// savePath�������ͼƬ�ı���Ŀ¼
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
		// ȡ���Á��ς����ļ�������
		List<File> files = getImages();
		// ѭ��ÿ���ϴ����ļ�
		for (int i = 0; i < files.size(); i++) {
			// �����ļ�������
			InputStream is = new FileInputStream(files.get(i));
			// �����ϴ��ļ�Ŀ¼
			String uploadPath = ServletActionContext.getServletContext()
					.getRealPath(getSavePath());
			// ����Ŀ���ļ�
			File toFile = new File(uploadPath, getImagesFileName().get(i));
			// �����
			OutputStream os = new FileOutputStream(toFile);
			// ���û���
			byte[] buffer = new byte[1024];
			int length = 0;
			// ��ȡfile[i]�ļ������toFile�ļ���
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			// �ر�������
			is.close();
			// �ر������
			os.close();
		}
	}

	/**
	 * ����DƬ
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
