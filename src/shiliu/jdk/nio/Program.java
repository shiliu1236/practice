package shiliu.jdk.nio;

import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Program {
	public static void main(String[] args) throws Exception {
		FileInputStream fin = new FileInputStream("test.txt");
		FileChannel fc = fin.getChannel();
	    ByteBuffer buffer = ByteBuffer.allocate(10);
	    outPut("初始化", buffer);
	    
	    fc.read(buffer);
	    outPut("调用read()", buffer);
	    
	    buffer.flip();
	    outPut("调用filp()", buffer);
	    
	    while(buffer.remaining()>0){
	    	byte b = buffer.get();
	    	System.out.println(b);
	    }
	    outPut("调用get()", buffer);  
	    
        buffer.clear();  
        outPut("调用clear()", buffer);  
  
        fin.close();  
	}
	public static void outPut(String step,Buffer buffer){
		System.out.println(step+":");
        System.out.print("capacity: " + buffer.capacity() + ", ");  
        System.out.print("position: " + buffer.position() + ", ");  
        System.out.println("limit: " + buffer.limit());  
        System.out.println();  
	}
}
