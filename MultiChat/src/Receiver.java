import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver implements Runnable {

/*
 * extends Thread, implements Runnable�� ������ ������ ���� ����մϴ�.
 * extends Thread�� Thread�� ��ӹް� ��äȭ�� �ڿ� ��ü��.start()�� ���� ����ϸ�,
 * implements Runnable�� Thread ��ü �ȿ� �����带 ����Ϸ��� ��ü�� �־��༭ ��üȭ�� �� ����մϴ�.
 * extends Thread�� implements Runnable�� ����մϴ�.
 * ������ implements Runnable�� ����ϸ� ���� ����� �����մϴ�.
 */
	Socket socket;
	DataInputStream in;
	String name;
	User user = new User();
	
	public Receiver(Socket socket, User user) throws IOException {
		this.socket = socket;
		this.user = user;
		in = new DataInputStream(socket.getInputStream());
		this.name = in.readUTF(); // UTF-8 �� ���ڵ� �� �о��
		user.AddClient(name,socket); // ����ڸ� ���
	}

	@Override
	public void run() {
		try {
			while(true) {
				String msg = in.readUTF(); // in�� ���� �޼����� UTF-8 �� ���ڵ� �� �о��
				user.sendMsg(msg,name); // name �̸��� ���� user�� msg��� �޼����� ����
			}
		}catch (Exception e) {
			user.RemoveClient(this.name); // ���� �߻��� name ������ client ���� ������
		}
	}
}
// Server ���� Client �� ������ ���� ����� ����Ǹ� Receiver Ŭ�������� User�� ����ϰ� �޼����� �ְ� ���� �� �ֵ���
// ���ʸ� �����Ѵ�.
// Receiver �� Send�� ���� �޼����� �޾� ������ش�.


