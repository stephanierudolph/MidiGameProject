package midiGame;

import javax.sound.midi.*;
//import java.util.ArrayList;
import java.util.List;
//import java.io.*;

public class MidiMain{

	public void midiMain(){
	    MidiDevice device;
	    MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
	    for (int i = 0; i < infos.length; i++) {
	        try {
	        device = MidiSystem.getMidiDevice(infos[i]);
	        //does the device have any transmitters?
	        //if it does, add it to the device list
	        System.out.println("Add to device: " + infos[i]);
	
	        //get all transmitters
	        List<Transmitter> transmitters = device.getTransmitters();
	        //and for each transmitter
	
	        for(int j = 0; j<transmitters.size();j++) {
	            //create a new receiver
	            transmitters.get(j).setReceiver(
	                    //using my own MidiReceiver
	                    new MidiReceiver(device.getDeviceInfo().toString())
	            );
	        }
	
	        Transmitter trans = device.getTransmitter();
	        trans.setReceiver(new MidiReceiver(device.getDeviceInfo().toString()));
	
	        //open each device
	        device.open();
	        //if code gets this far without throwing an exception
	        //print a success message
	        System.out.println(device.getDeviceInfo()+" Was Opened");
	
	
	        } catch (MidiUnavailableException e) {}
	    }
	}

}
