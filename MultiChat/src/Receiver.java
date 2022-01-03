import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver implements Runnable {

/*
 * extends Thread, implements Runnable은 쓰레드 구현을 위해 사용합니다.
 * extends Thread는 Thread를 상속받고 객채화한 뒤에 객체명.start()를 통해 사용하며,
 * implements Runnable은 Thread 객체 안에 쓰레드를 사용하려는 객체를 넣어줘서 객체화한 뒤 사용합니다.
 * extends Thread와 implements Runnable은 비슷합니다.
 * 하지만 implements Runnable을 사용하면 다중 상속이 가능합니다.
 */
	Socket socket;
	DataInputStream in;
	String name;
	User user = new User();
	
	public Receiver(Socket socket, User user) throws IOException {
		this.socket = socket;
		this.user = user;
		in = new DataInputStream(socket.getInputStream());
		this.name = in.readUTF(); // UTF-8 로 인코딩 후 읽어옴
		user.AddClient(name,socket); // 사용자를 등록
	}

	@Override
	public void run() {
		try {
			while(true) {
				String msg = in.readUTF(); // in에 들어온 메세지를 UTF-8 로 인코딩 후 읽어옴
				user.sendMsg(msg,name); // name 이름을 가진 user가 msg라는 메세지를 보냄
			}
		}catch (Exception e) {
			user.RemoveClient(this.name); // 에러 발생시 name 유저를 client 에서 삭제함
		}
	}
}
// Server 에서 Client 와 소켓을 통해 통신이 연결되면 Receiver 클래스에서 User를 등록하고 메세지를 주고 받을 수 있도록
// 기초를 마련한다.
// Receiver 는 Send가 보낸 메세지를 받아 출력해준다.


