package com.mypro.manager;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import com.mypro.model.GamingInfo;




/**
 * ���ֹ�����
 * @author Xiloerfan
 *
 */
public class MusicManager {
	private static MusicManager manager;
//	private MediaPlayer mediaPlayer;
	private AudioInputStream audioInputStream;// �ļ���

	private AudioFormat audioFormat;// �ļ���ʽ

	private SourceDataLine sourceDataLine;// ����豸
	
	public static MusicManager getMusicManager(){
		if(manager==null){
			manager = new MusicManager();
		}
		return manager;
	}
	/**
	 * ˽�еĹ�����
	 */
	private MusicManager(){
//		this.mediaPlayer = new MediaPlayer();
	}
	/**
	 * ���R�ļ��ж�Ӧ��ID������4������Ч
	 * @param resId
	 */
	public void playMusicByR(String resId,boolean isLoop){
		try {
			File file = new File("bgm"+File.separator+resId);


			

			Thread playThread = new Thread(new PlayThread(file,true));
			playThread.start();
			
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	/**
	 * ��ȡR����raw�еľ�̬���Ե�ֵ
	 * @param fieldName		������
	 * @return				-1:û���ҵ���Ӧ������
	 */
	private int getStaticFieldValueByR(String fieldName){
//		try{
//			for(Field f:R.raw.class.getFields()){
//				if(f.getName().equals(fieldName)){
//					return f.getInt(null);
//				}
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return -1;
	}
	
	/**
	 * �ͷ���Դ
	 */
	public static void release(){
//		if(manager!=null&&manager.mediaPlayer!=null){
//			if(manager.mediaPlayer.isPlaying()){
//				manager.mediaPlayer.stop();			
//			}
//			manager.mediaPlayer.release();
//		}
//		manager=null;
	}
	
	class PlayThread extends Thread {
		public boolean isLoop;
		File musicFile;
		byte tempBuffer[] = new byte[320];
		public PlayThread(File musicFile,boolean isLoop){
			this.musicFile = musicFile;
			this.isLoop = isLoop;
		}
		public void run() {

			try {

				int cnt;
				do{	
					// ȡ���ļ�������

					audioInputStream = AudioSystem.getAudioInputStream(musicFile);

					audioFormat = audioInputStream.getFormat();

					// ת��mp3�ļ�����

					if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {

						audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,

						audioFormat.getSampleRate(), 16, audioFormat

						.getChannels(), audioFormat.getChannels() * 2,

						audioFormat.getSampleRate(), false);

						audioInputStream = AudioSystem.getAudioInputStream(audioFormat,

						audioInputStream);

					}
					// ������豸

					DataLine.Info dataLineInfo = new DataLine.Info(

					SourceDataLine.class, audioFormat,

					AudioSystem.NOT_SPECIFIED);

//					sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
//
//					sourceDataLine.open(audioFormat);
//
//					sourceDataLine.start();
					// ��ȡ��ݵ��������
	
					while ((cnt = audioInputStream.read(tempBuffer, 0,
	
					tempBuffer.length)) != -1) {
	
						if (!GamingInfo.getGamingInfo().isGaming())
	
							break;
	
//						if (cnt > 0) {
//	
//							// д�뻺�����
//	
//							sourceDataLine.write(tempBuffer, 0, cnt);
//	
//						}
	
					}
	
					// Block�ȴ���ʱ��ݱ����Ϊ��
//	
//					sourceDataLine.drain();	
//					sourceDataLine.close();
				}while(isLoop&&GamingInfo.getGamingInfo().isGaming());
			} catch (Exception e) {

				e.printStackTrace();

				System.exit(0);

			}

		}

	}
}
