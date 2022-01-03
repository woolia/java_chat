import java.io.DataInputStream;
import java.io.FileInputStream;

/*
 * DataOutputStream �� �̿��Ͽ� test.txt ���Ͽ� ���̳ʸ� ���·� �Է��ߴ� �ڹ� �⺻ ������ Ÿ�� �����͸�
 * DataInputStream �� �̿��ؼ� �ٽ� �о�� �� �ִ�.
 * 
 */

public class ReadData {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream f = null;
		DataInputStream in = null;

		try {
			f = new FileInputStream("C:\\Java\\test.txt");
			in = new DataInputStream(f); // ���Ͽ� ����� ������ �Է� ��Ʈ�� ����
			System.out.println(in.readBoolean()); // 1����Ʈ�� �о� boolean�� ��ȯ
			System.out.printf("%x\n",(byte)in.readByte()); // 1����Ʈ�� �о� byte�� ��ȯ
			System.out.printf("%x\n",in.readShort()); // 2����Ʈ�� �о� short�� ��ȯ
			System.out.printf("%d\n",in.readInt()); // 4����Ʈ�� �о� int�� ��ȯ
			System.out.printf("%d\n",in.readLong()); // 8����Ʈ�� �о� long�� ��ȯ
			System.out.println((char)in.readChar()); // 2����Ʈ�� �о� char�� ��ȯ
			System.out.println(in.readDouble()); // 8����Ʈ�� �о� double�� ��ȯ
			System.out.println(in.readFloat()); // 4����Ʈ�� �о� float�� ��ȯ
			System.out.println(in.readUTF()); // UTF-8�� ���ڵ��� ���ڿ��� �о� ��ȯ				
			in.close();
			f.close();
			
		}catch (Exception e) {
			System.out.println("����� ����");
		}
		
	}

}
