package com.danone.batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.Resource;

public class FlatFileSaludo extends FlatFileItemReader<SaludoInput> {

	private Resource resource;
	@Override
	public void setResource(Resource resource) {
		System.err.println("Archivo: "+resource.getFilename());
		this.resource = resource;
		super.setResource(resource);
	}
	
	@Override
	protected void doClose() throws Exception {
		super.doClose();
		if(resource != null){
		System.err.println("Se cierra Archivo.... doClose().. "+resource.getFilename()+"...!!");
		File file = resource.getFile();
//		moveFile(file);
		moveProcessed(file);
		
		}
	}

	private void moveProcessed(File file) {
		String parent = file.getParent();
		String newParent = parent.substring(0, parent.length()-3) + "processed/";
		if(file.renameTo(new File(newParent + file.getName()))){
			System.out.println("Se movio archivo OK");
		}else{
			System.out.println("Se movio archivo ERROR");
		}
	}
	
	
	@Override
	protected void doOpen() throws Exception {
		System.err.println("Se abre el archivo Archivo... doOpen()..!!");
		super.doOpen();
	}
	
    protected void moveFile(File afile)
    {	
 
    	InputStream inStream = null;
	OutputStream outStream = null;
 
    	try{
 
//    	    File afile =new File("C:\\folderA\\Afile.txt");
    	    File bfile =new File("C:\\interface_SAP_QS3\\data\\in\\orderCreation\\processed\\"+afile.getName());
 
    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    //delete the original file
    	    afile.delete();
 
    	    System.out.println("File is copied successful!");
 
    	}catch(IOException e){
    	    e.printStackTrace();
    	}
    }

}
