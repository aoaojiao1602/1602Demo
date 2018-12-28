package com.ysd.boot.utils;

import java.io.File;
import java.util.List;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
/**
 * Jave项目简单使用示例
 * 其它功能参考: https://baike.xsoftlab.net/view/746.html
 * @author MaShuai
 *
 */
public class VideoAudioUtils {
	/**
	 * 获取视频音频文件大小
	 * @return
	 */
	public static Long getVideoLength() {
		 File f= new File("C:\\\\Users\\\\Administrator\\\\Desktop\\\\NutzIOC.mp4");
		 System.out.println("此视频音频大小为:" + f.length() + "b");
		 System.out.println("此视频音频大小为:" + (f.length()/1024) + "k");
		 System.out.println("此视频音频大小为:" + (f.length()/(1024*1024)) + "m");		 
		 return f.length();
		    
	}
	
	/**
	 * 获取视频音频文件时长
	 * @return
	 */
	public static Integer getVideoSecond(String filepath) {
		File path=new File(filepath);
        Encoder encoder = new Encoder();
        Integer second = null;
        try {
            MultimediaInfo m = encoder.getInfo(path);
            long ls = m.getDuration();//获取视频音频文件的时长单位毫秒
            second = Long.valueOf(ls/1000).intValue();
            System.out.println("此视频音频时长为:" + second + "秒！");

   		 System.out.println("此视频高度为:"+m.getVideo().getSize().getHeight());

   		 System.out.println("此视频宽度为:"+m.getVideo().getSize().getWidth());

   		 System.out.println("此视频格式为:"+m.getFormat());//输出的是源格式,实际去后缀.mp4即可
        } catch (Exception e) {
            e.printStackTrace();
        }
        return second;
	}
	
	/**
	 * 获取视频截图
	 * 获取视频文件的第几秒的视频截图
	 * 截屏是保存在 视频的那个目录
需要一个ffmpeg.exe 可以百度下载或者这里下载解压。
ffmpeg.exe在bin目录下有一个ffmpeg.exe
下载地址：
https://ffmpeg.zeranoe.com/builds/win64/static/ffmpeg-20181213-e5a0013-win64-static.zip
	 * @param veido_path
	 * @param ffmpeg_path
	 * @return
	 */
	public static boolean processImg(String veido_path,String ffmpeg_path) {

		File file = new File(veido_path);

		if (!file.exists()) {

		System.err.println("路径[" + veido_path + "]对应的视频文件不存在!");

		return false;

		}

		List<String> commands = new java.util.ArrayList<String>();

		commands.add(ffmpeg_path);

		commands.add("-i");

		commands.add(veido_path);

		commands.add("-y");

		commands.add("-f");

		commands.add("image2");

		commands.add("-ss");

		commands.add("10");//这个参数是设置截取视频多少秒时的画面

		commands.add("-t");

		commands.add("0.001");

		commands.add("-s");

		commands.add("1920x1080");//宽X高

		commands.add(veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");

		try {

		ProcessBuilder builder = new ProcessBuilder();

		builder.command(commands);

		builder.start();

		System.out.println("截取成功");

		return true;

		} catch (Exception e) {

		e.printStackTrace();

		return false;

		}

		}

}
