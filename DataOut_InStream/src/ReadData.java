import java.io.DataInputStream;
import java.io.FileInputStream;

/*
 * DataOutputStream 을 이용하여 test.txt 파일에 바이너리 형태로 입력했던 자바 기본 데이터 타입 데이터를
 * DataInputStream 을 이용해서 다시 읽어올 수 있다.
 * 
 */

public class ReadData {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream f = null;
		DataInputStream in = null;

		try {
			f = new FileInputStream("C:\\Java\\test.txt");
			in = new DataInputStream(f); // 파일에 연결된 데이터 입력 스트림 생성
			System.out.println(in.readBoolean()); // 1바이트를 읽어 boolean값 반환
			System.out.printf("%x\n",(byte)in.readByte()); // 1바이트를 읽어 byte값 반환
			System.out.printf("%x\n",in.readShort()); // 2바이트를 읽어 short값 반환
			System.out.printf("%d\n",in.readInt()); // 4바이트를 읽어 int값 반환
			System.out.printf("%d\n",in.readLong()); // 8바이트를 읽어 long값 반환
			System.out.println((char)in.readChar()); // 2바이트를 읽어 char값 반환
			System.out.println(in.readDouble()); // 8바이트를 읽어 double값 반환
			System.out.println(in.readFloat()); // 4바이트를 읽어 float값 반환
			System.out.println(in.readUTF()); // UTF-8로 인코딩된 문자열을 읽어 반환				
			in.close();
			f.close();
			
		}catch (Exception e) {
			System.out.println("입출력 오류");
		}
		
	}

}
