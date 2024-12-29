package midiGame;
import javax.sound.midi.*;

public class MidiReceiver implements Receiver { //receives midi input
public String name;
public MidiReceiver(String name) {
    this.name = name;
}
public void send(MidiMessage msg, long timeStamp) {

    byte[] aMsg = msg.getMessage();
    System.out.println("");
    System.out.println("Printing message length: " + msg.getLength());
    // take the MidiMessage msg and store it in a byte array

    //msg.getLength() returns the length of the message in bytes
   String[] type = {"Velocity: ", "Note Value Int: ", "On/Off Scale: "};
    for(int i=0;i<msg.getLength();i++){
    	System.out.println(type[i] + aMsg[i]);
    	
    	int print = 0;
    	if (i == 2 && aMsg[i] == 0) {
    		print++;
    		System.out.println(print);
    	}else if ( i == 2 && aMsg[i] >100 && print !=1) {
    		print--;
    		System.out.println(print);
    	}else {}
    	if (i ==2 && print == 0) {
    		System.out.println("Detected Note Press");
    	}
    }
    System.out.println("Loop ends.");
    System.out.println();
} 
public void close() {}
}