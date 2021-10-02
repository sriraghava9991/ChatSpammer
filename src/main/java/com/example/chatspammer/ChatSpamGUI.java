package com.example.chatspammer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jnativehook.NativeHookException;

public class ChatSpamGUI {

	static File file;
	static JPanel southPanel;
	static JButton startButton;
	static JButton stopButton;
	static JButton chooseFile;
	static JButton clear;
	static JComboBox<String> languages;
	static JFrame frame;
	static JTextArea textArea;
	static Document document;
	private static final Dimension REASON_AREA_SIZE = new Dimension(250, 50);

	public static void main(String args[]) {
		ChatOption.isGUI = true;
		String title = "";
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 600);
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(true);
		JScrollPane lScrollPane = new JScrollPane(textArea);
		lScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		lScrollPane.setPreferredSize(REASON_AREA_SIZE);
		frame.add(lScrollPane, BorderLayout.CENTER);
		frame.add(createSouthPanel(), BorderLayout.SOUTH);

		// Here the close button is defined by default, the focus should be on it
		setDefaultButton();

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(title);
		frame.setVisible(true);
		textArea.setBackground(Color.red);

		textArea.getDocument().addDocumentListener(new BecomingRedDocumentListener(textArea));

	}

	private static JPanel createSouthPanel() {
		southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		southPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		addCloseButton(southPanel);

		return southPanel;
	}

	/**
	 * Set the close button as default
	 */
	protected static void setDefaultButton() {
		frame.getRootPane().setDefaultButton(startButton);
	}

	private static void addCloseButton(JPanel pButtonsPanel) {
		startButton = new JButton("Start Spamming");
		chooseFile = new JButton("Choose File");
		clear = new JButton("Clear");
		stopButton = new JButton("Stop Spamming");

		chooseFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fileChooser();
					try {
						fillTextArea();
					} catch (FontFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent pEvent) {
				try {
					ChatSpammer.startKeyStrokeMonitor();
				} catch (NativeHookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// frame.dispose();
			}
		});
		
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent pEvent) {
				try {
					ChatSpammer.stopKeyStrokeMonitor();
				} catch (NativeHookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent pEvent) {
				textArea.setText(null);
			}
		});

		File folder = new File("src\\main\\resources\\Languages");
		File[] listOfFiles = folder.listFiles();
		String[] languageList = new String[folder.listFiles().length + 1];
		languageList[0] = "English";

		for (int i = 0; i < listOfFiles.length; i++) {
			languageList[i + 1] = listOfFiles[i].getName().replace(".ttf", "");
		}
		Font font = new Font("Arial Unicode MS", Font.PLAIN, 40);
		textArea.setFont(font);

		languages = new JComboBox<String>(languageList);
		languages.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				languages.getSelectedItem().toString();
				String selectedLanguage = languages.getSelectedItem().toString();

				try {
					if (selectedLanguage.equals("English")) {
						Font font = new Font("Arial Unicode MS", Font.PLAIN, 40);
						textArea.setFont(font);					
						} else {
						textArea.setFont(createFont("Languages/" + selectedLanguage + ".ttf"));

						UnicodeMap.generateDefaultMap();
						UnicodeMap.offset=UnicodeMap.decimalMap.get(selectedLanguage);
						UnicodeMap.generateUnicodeFromOffset();
						String textUnicode=textArea.getText();
						String textesc=StringEscapeUtils.escapeJava(textUnicode);
						System.out.println(textesc);
						textArea.setText(TranslateText.devTranslate(textArea.getText()));
					}
				} catch (FontFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		pButtonsPanel.add(clear);
		pButtonsPanel.add(languages);
		pButtonsPanel.add(chooseFile);
		pButtonsPanel.add(startButton);
		pButtonsPanel.add(stopButton);
	}

	public static void fileChooser() throws IOException {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		if (JFileChooser.APPROVE_OPTION == result) {
			file = chooser.getSelectedFile();

			JOptionPane.showMessageDialog(null, "Browse");

		}
	}

	public static void fillTextArea() throws IOException, FontFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
		String str = "";
		String s;
		while ((s = in.readLine()) != null) {
			str = str + s + "\n";
		}
		Font telugu = createFont("Languages/Telugu.ttf");
		textArea.append(str);
		textArea.setFont(telugu);

	}

	private static Font createFont(String url) throws FontFormatException, IOException {
		return Font.createFont(Font.TRUETYPE_FONT, ChatSpamGUI.class.getClassLoader().getResourceAsStream(url))
				.deriveFont(30f);
	}

	private static class BecomingRedDocumentListener implements DocumentListener {
		private JTextArea textField;

		public BecomingRedDocumentListener(JTextArea textField) {
			this.textField = textField;
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			if("English".equals(languages.getSelectedItem().toString()))
					return;
			SwingUtilities.invokeLater(() -> {
				String tf=textField.getText();
				if(Optional.ofNullable(textField.getText()).map(str->!str.isEmpty()).orElse(false))
				if(tf.length()<1000)
					textField.setText(TranslateText.devTranslate(textField.getText()));
				else {
					textField.setText(tf.substring(0,tf.lastIndexOf(" ")+1)
							+TranslateText.devTranslate(tf.substring(tf.lastIndexOf(" ")+1)));
				}

			});
		}

		@Override
		public void removeUpdate(DocumentEvent e) {

		}

		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	}

}