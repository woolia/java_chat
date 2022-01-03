import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

/*
 * extends Thread, implements Runnable 은 쓰레드 구현을 위해 사용한다.
 * extends Thread는 Thread를 상속받고 객체화한 뒤에 객체명.start() 를 통해 사용한다.
 * implements Runnable은 Thread 객체 안에 쓰레드를 사용하려는 객체를 넣어줘서 객체화한 뒤 사용한다.
 * extends Thread와 implements Runnable 은 비슷하다.
 * 하지만 implements Runnable 을 사용하면 다중 상속이 가능하다.
 */

public class Send implements Runnable {

	DataOutputStream out;
	/*
	 * DataOutputStream 은 자바의 기본 데이터 타입별로 출력하는 별도의 메소드가 존재한다.
	 * 예를 들어, double 데이터를 출력하려면 writeDouble(double v), char 데이터를 출력하려면 writeChar(int v)를 이용한다.
	 * 문자열을 출력할때는 writeUTF(String str)을 사용한다.
	 * DataOutputStream을 사용하면 바이너리 형태로 입력된다.
	 */
	/*
	 *  ※ DataInputStream
	 *  DataOutputStream을 이용해서 txt 파일에 바이너리 형태로 입력했던 자바 기본 데이터 타입 데이터를 DataInputStream 을 이용해서 다시 읽어올 수 있다.
	 *  예를 들어, double 데이터를 읽으려면 readDouble(), char 데이터를 읽을 때는 readChar() 를 사용한다.
	 *  문자열을 읽을 때는 readUTF() 을 사용한다. 
	 */
	
	BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
	// Send 클래스에서의 in2 는 채팅 내용을 받아오는 역할을 한다.
	// BufferedReader 와 InputStreamReader 내용은 https://st-lab.tistory.com/41 여기서 확인 가능
	// 김영렬 그는 신이다...
	
	public Send(DataOutputStream out) {
		this.out = out;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String msg = in2.readLine(); // 메세지를 받아옴
				out.writeUTF(msg); // msg 를 출력
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

// Send 클래스는 유저가 보낸 닉네임과 메세지 등을 서버에 전달하는 역할을 한다.
// Thread를 통해 동작하기 때문에 Runnable 이라는 조건자를 달음
