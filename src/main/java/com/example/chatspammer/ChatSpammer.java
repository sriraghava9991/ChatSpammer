package com.example.chatspammer;

import java.io.File;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class ChatSpammer implements NativeKeyListener {
	static Thread chatThread;

	public static void main(String[] args) throws Exception {
		ChatOption.file = new File("C:\\Users\\Public\\test.txt");

		startKeyStrokeMonitor();
	}

	public static void startKeyStrokeMonitor() throws NativeHookException {

		GlobalScreen.registerNativeHook();
		GlobalScreen.addNativeKeyListener(new ChatSpammer());
	}
	
	public static void stopKeyStrokeMonitor() throws NativeHookException {

		chatThread.interrupt();
		GlobalScreen.unregisterNativeHook();
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		if (arg0.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			if (chatThread != null && chatThread.isAlive()) {
				chatThread.interrupt();
			} else {
				chatThread = new Thread(new ChatThread());
				chatThread.start();
			}
		}

	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {

	}

}
