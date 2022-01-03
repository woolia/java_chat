import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

	public static void main(String[] args) {
		
		Socket socket = null; // Server와 통신하기 위한 Client의 Socket
		BufferedReader in = null; // Server로부터 데이터를 읽어들이기 위한 입력스트림
		BufferedReader in2 = null; // 키보드로부터 읽어들이기 위한 입력스트림 
		PrintWriter out = null; // 서버로 내보내기 위한 출력 스트림
		
		InetAddress ia = null; 
		
		try {
			ia = InetAddress.getLocalHost(); // 서버로 접속하기 위해 서버 주소를 입력
			
			/*
			 * 클라이언트-서버 간의 네트워크 통신 할때 필요한 것은 두가지 이다.
			 * 클라이언트는 서버의 IP 주소와 포트번호를 알아야한다.
			 * 여기서는 컴퓨터 한대로 클라이언트-서버 통신을 하기 때문에 ia에 getLocalHost()를 사용하여
			 * Local IP Address(본인 IP 주소)를 불러옴
			 * 포트번호는 4444로 지정했기 때문에 4444를 입력한다.
			 */
			
			socket = new Socket(ia,4444);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // BufferedReader 선언
			in2 = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader2 선언
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			
			System.out.println(socket.toString());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			System.out.print("서버로 보낼 메세지 : ");
			String data = in2.readLine(); // 키보드로부터 입력
			out.println(data);
			out.flush();
			
			String data2 = in.readLine();
			System.out.println("서버로부터 되돌아온 메세지 : " + data2);

			socket.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
