import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamEx {

	/*
	 * DataOutputStream �� �ڹ��� �⺻ ������ Ÿ�Ժ��� ����ϴ� ������ �޼ҵ尡 ����
	 * �⺻ �����͸� �Ű� ������ ȣ��
	 * 
	 * DataOutputStream ���� "C:\\Java\\test.txt" ���Ͽ� �������� �ڹ� �⺻ Ÿ�Ժ��� �����͸� ����ϴ� ���� �ۼ�
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileOutputStream f = null;
		DataOutputStream out = null;
		
		try {
			f = new FileOutputStream("C:\\Java\\test.txt");
			out = new DataOutputStream(f);
			
			out.writeBoolean(false); // 0x00 ���
			out.writeByte(0x33); // 0x33 ���
			out.writeShort(0x1234); // 0x1234 ���
			out.writeInt(30); // 0x00005678 ���
			out.writeLong(1000); // 0x0000000012abcdef ���
			out.writeChar('c'); // 0x0063 ���
			out.writeDouble(0.12e-3); // 0x0063 ���
			out.writeFloat((float) 3.14); // int�� ��ȯ �� 0x4048f5c3 ���
			out.writeUTF("�����ٶ�"); // UTF-8�� ���ڵ� �� 0x000ceab080eb8298eb8ba4eb9dbc ���
			out.close();
			f.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("����� ����");
		}
		
	}

}
