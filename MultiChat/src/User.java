import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class User {
	
	HashMap<String,DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();
	// clientMap 은 String 형 key 와 DataOutputStream 형의 value 값을 받음

	public void AddClient(String name, Socket socket) {
		// TODO Auto-generated method stub
		try {
			
			sendMsg(name + " 님이 입장했습니다.","Server"); // server에 입장 메세지를 전달
			clientMap.put(name, new DataOutputStream(socket.getOutputStream()));
			// HashMap의 put(key,value) 함수는 key와 value를 받는다.
			
			System.out.println("채팅 참여 인원 : "+ clientMap.size());
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void RemoveClient(String name) {
		// TODO Auto-generated method stub
		
		try {
			clientMap.remove(name); // name을 가지는 client를 제거함
			sendMsg(name + " 님이 퇴장하였습니다." , "Server");
			System.out.println("채팅 참여 인원 : "+clientMap.size());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sendMsg(String msg, String name) throws IOException {
		// TODO Auto-generated method stub
		
		Iterator iterator = clientMap.keySet().iterator(); // clientMap의 key 값들을 iterator로 불러옴
		
		while(iterator.hasNext()) {// iterator로 하나씩 key값을 가져오고 key 값이 존재할때까지 while 문 반복 다음 key값이 없으면 자동 break
			// hasNext()는 단순하게 다음 값이 존재하는지 Boolean 형태로 return 값이 있으면 true 없으면 false
			String clientName = (String) iterator.next(); // next() 를 사용하면 iterator가 값을 가져옴 이때 이전 값을 사라짐
			clientMap.get(clientName).writeUTF(name + " : " + msg);
			// 양식대로 채팅을 출력합니다.
			// writeUTF를 할때 throw를 던져야 하나 봄
		}
	}
}

// Client 에게 User 권한을 얻을 수 있도록 해주는 클래스이다.
// Server에서 Receiver 가 선언되면, Receiver를 통해 User가 등록되고 , User 클래스를 통해 양식에 맞춰
// 실제 우리 눈에 보이게 되는 메세지를 전달할 수 있게 된다.



// 최종 실행
// 1. 서버를 오픈 (Server 클래스 실행)
// 2. Client 클래스를 실행하고 닉네임을 입력
// 3. Server 실행창으로 넘어오면 누군가 1명이 접속한 것을 확인 할 수 있다.
// 4.
