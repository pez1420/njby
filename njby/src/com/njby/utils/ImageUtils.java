package com.njby.utils;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图片工具类
 */
public final class ImageUtils {

    /**
     * 图片缩放
     * @param org    原图路径
     * @param dest   缩放图路径
     * @param height 高度
     * @param width  宽度
     */
    public static boolean resize(String org, String dest, int height, int width) {
    	    boolean bol = false; //是否进行了压缩
    	    //LogRecord.recode(ImageUtils.class, "resize", org);
    		String pictype="";
    		if(!"".equals(org)&&org!=null){
    			pictype = org.substring(org.lastIndexOf(".")+1,org.length());
    		}
    		//LogRecord.recode(ImageUtils.class, "height:",""+height);
           // LogRecord.recode(ImageUtils.class, "width:",""+width);	
            double ratio = 0; //缩放比例
            File o = new File(org);
            File d = new File(dest);
            BufferedImage bi;
			try {
				bi = ImageIO.read(o);
                Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
	            int itempWidth = bi.getWidth();
	            int itempHeight = bi.getHeight();
	            //LogRecord.recode(ImageUtils.class, "itempHeight:",""+itempHeight);
	          //  LogRecord.recode(ImageUtils.class, "itempWidth:",""+itempWidth);

	            //计算比例   
	            if ((itempHeight > height) || (itempWidth > width)) {
                	//LogRecord.recode(ImageUtils.class, "【开始图片缩放】-----pictype:", pictype);
					ratio = Math.min((new Integer(height)).doubleValue() / itempHeight, (new Integer(width)).doubleValue() / itempWidth);
					AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
					itemp = op.filter(bi, null);
					ImageIO.write((BufferedImage) itemp,pictype, d);
					bol = true;
               }
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return bol;
    }

    public static void resizeWidth(String org,String dest, int height, int width) {
    	//LogRecord.recode(ImageUtils.class, "resizeWidth", org);
    		String pictype="";
    		if(!"".equals(org)&&org!=null){
    			pictype = org.substring(org.lastIndexOf(".")+1,org.length());
    		}
            double ratio = 0; //缩放比例
            File o = new File(org);
            File d = new File(dest);
            BufferedImage bi;
			try {
				bi = ImageIO.read(o);
                Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
	            int itempWidth = bi.getWidth();
	           // LogRecord.recode(ImageUtils.class, "itempWidth:",""+itempWidth);

	            //计算比例   
	            if (itempWidth != width) {
                	//LogRecord.recode(ImageUtils.class, "【开始图片缩放 width】-----pictype:", pictype);
					ratio = ((new Integer(width)).doubleValue() / itempWidth);
					AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
					itemp = op.filter(bi, null);
					ImageIO.write((BufferedImage) itemp,pictype, d);
               }
	           
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    }
    
    public static void copyFile(String sourcePath, String targetPath){
        BufferedInputStream inBuff=null;
        BufferedOutputStream outBuff=null;
        try {
        	File sourceFile = new File(sourcePath);
        	File targetFile = new File(targetPath);
        	if(!targetFile.exists()){
        		targetFile.getParentFile().mkdirs();
        	}
            // 新建文件输入流并对它进行缓冲
            inBuff=new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff=new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b=new byte[1024 * 5];
            int len;
            while((len=inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } catch(IOException e){
        	//LogRecord.recode(ImageUtils.class, "图片复制异常:", e.getMessage());
        } finally {
            // 关闭流
				try {
					 if(inBuff != null)
						 inBuff.close();
					 if(outBuff != null)
			             outBuff.close();
				} catch (IOException e) {
					//LogRecord.recode(ImageUtils.class, "文件流关闭异常:", e.getMessage()); 
				}
            
        }
    }

    public static void main(String[] args) throws IOException{
        //pressImage("D:\\images\\444.jpg", "D:\\images\\wmlogo.gif", 100, 50, 0.5f);
//        pressText("D:\\\\images\\\\444.jpg", "旺仔之印", "宋体", Font.BOLD|Font.ITALIC, 20, Color.red, 50, 50,.8f);
    	//resizeWidth("c:\\test\\VIP3.png","c:\\test\\VIP3_1.png", 90, 245); 
		//resize("E:\\testdata\\1.jpg","E:\\testdata\\2.jpg", 200, 200);  
    	
    	//String targetPath = "111.jpg".substring(0,"111.jpg".indexOf(".jpg"));
    	//System.out.println(targetPath); 
	}
}
