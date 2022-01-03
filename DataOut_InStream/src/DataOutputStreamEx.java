import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamEx {

	/*
	 * DataOutputStream 은 자바의 기본 데이터 타입별로 출력하는 별도의 메소드가 존재
	 * 기본 데이터를 매개 변수로 호출
	 * 
	 * DataOutputStream 으로 "C:\\Java\\test.txt" 파일에 여러가지 자바 기본 타입별로 데이터를 기록하는 예제 작성
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileOutputStream f = null;
		DataOutputStream out = null;
		
		try {
			f = new FileOutputStream("C:\\Java\\test.txt");
			out = new DataOutputStream(f);
			
			out.writeBoolean(false); // 0x00 출력
			out.writeByte(0x33); // 0x33 출력
			out.writeShort(0x1234); // 0x1234 출력
			out.writeInt(30); // 0x00005678 출력
			out.writeLong(1000); // 0x0000000012abcdef 출력
			out.writeChar('c'); // 0x0063 출력
			out.writeDouble(0.12e-3); // 0x0063 출력
			out.writeFloat((float) 3.14); // int로 변환 후 0x4048f5c3 출력
			out.writeUTF("가나다라"); // UTF-8로 인코딩 후 0x000ceab080eb8298eb8ba4eb9dbc 출력
			out.close();
			f.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("입출력 에러");
		}
		
	}

}
