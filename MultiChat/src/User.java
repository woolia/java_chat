import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class User {
	
	HashMap<String,DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();
	// clientMap �� String �� key �� DataOutputStream ���� value ���� ����

	public void AddClient(String name, Socket socket) {
		// TODO Auto-generated method stub
		try {
			
			sendMsg(name + " ���� �����߽��ϴ�.","Server"); // server�� ���� �޼����� ����
			clientMap.put(name, new DataOutputStream(socket.getOutputStream()));
			// HashMap�� put(key,value) �Լ��� key�� value�� �޴´�.
			
			System.out.println("ä�� ���� �ο� : "+ clientMap.size());
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void RemoveClient(String name) {
		// TODO Auto-generated method stub
		
		try {
			clientMap.remove(name); // name�� ������ client�� ������
			sendMsg(name + " ���� �����Ͽ����ϴ�." , "Server");
			System.out.println("ä�� ���� �ο� : "+clientMap.size());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sendMsg(String msg, String name) throws IOException {
		// TODO Auto-generated method stub
		
		Iterator iterator = clientMap.keySet().iterator(); // clientMap�� key ������ iterator�� �ҷ���
		
		while(iterator.hasNext()) {// iterator�� �ϳ��� key���� �������� key ���� �����Ҷ����� while �� �ݺ� ���� key���� ������ �ڵ� break
			// hasNext()�� �ܼ��ϰ� ���� ���� �����ϴ��� Boolean ���·� return ���� ������ true ������ false
			String clientName = (String) iterator.next(); // next() �� ����ϸ� iterator�� ���� ������ �̶� ���� ���� �����
			clientMap.get(clientName).writeUTF(name + " : " + msg);
			// ��Ĵ�� ä���� ����մϴ�.
			// writeUTF�� �Ҷ� throw�� ������ �ϳ� ��
		}
	}
}

// Client ���� User ������ ���� �� �ֵ��� ���ִ� Ŭ�����̴�.
// Server���� Receiver �� ����Ǹ�, Receiver�� ���� User�� ��ϵǰ� , User Ŭ������ ���� ��Ŀ� ����
// ���� �츮 ���� ���̰� �Ǵ� �޼����� ������ �� �ְ� �ȴ�.



// ���� ����
// 1. ������ ���� (Server Ŭ���� ����)
// 2. Client Ŭ������ �����ϰ� �г����� �Է�
// 3. Server ����â���� �Ѿ���� ������ 1���� ������ ���� Ȯ�� �� �� �ִ�.
// 4.
