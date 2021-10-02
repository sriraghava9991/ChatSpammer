package com.example.chatspammer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class ChatThread implements Runnable {

	public File file = null;
	BufferedReader br = null;
	static ArrayList<String> alist = new ArrayList<String>();

	public void run() {

		try {
			File file = ChatOption.file;

			String str;
			while (!ChatOption.isGUI) {
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
				while ((str = in.readLine()) != null) {
					printLine(str);
				}
			}
			while (ChatOption.isGUI) {
				String lines[] = ChatSpamGUI.textArea.getText().split("\\n");
				for (int i = 0; i < lines.length; i++) {
					printLine(lines[i]);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void printLine(String str) throws InterruptedException, AWTException {
		StringSelection stringSelection = new StringSelection(str);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);

	}

}