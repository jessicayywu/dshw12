/**
  * Name: Yen-Yi Wu
  * ID: U10216020
  * Ex.: 12
  * Information:
  *             DS程式作業7：實作single linked list
  *             以Java applet實作single linked list
  */
package dshw12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SingleLinkedListApplet extends JApplet implements ActionListener {
	/** Create Components
	========================================================= */
	
	/** Insert
	--------------------------------- */
	private JLabel jlInsert = new JLabel("插入");
	private String[] insertAt = {"開頭", "尾端"};
	private JComboBox jcboInsertAt = new JComboBox(insertAt);
	private JTextField jtfInsert = new JTextField();
	private JButton jbtInsert = new JButton("確定");
	
	/** Delete
	--------------------------------- */
	private JButton jbtDeleteHead = new JButton("刪除開頭");
	private JButton jbtDeleteTail = new JButton("刪除尾端");
	
	/** Others
	--------------------------------- */
	private JButton jbtClearSLL = new JButton("Clear SLL");
	private JButton jbtPrintAll = new JButton("Print All");
	
	/** Search
	--------------------------------- */
	private JLabel jlSearch = new JLabel("搜尋：");
	private JTextField jtfSearch = new JTextField();
	private JButton jbtSearch = new JButton("確定");
	private JTextField jtfSearchResult = new JTextField();
	
	/** Process
	--------------------------------- */
	private JLabel jlProcess = new JLabel("過程：");
	private JTextArea jtaProcess= new JTextArea();
	
	/** Initialize the list
	--------------------------------- */
	SingleLinkedList list = new SingleLinkedList();
	
	/////////////////////////////////////////////////////////////
	
	/** Initialize the Applet
	========================================================= */
	public void init() {
		/** Insert
		--------------------------------- */
		JPanel p111 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		p111.add(jlInsert);
		p111.add(jcboInsertAt);
		
		JPanel p11 = new JPanel(new BorderLayout(10, 5));
		p11.add(p111, BorderLayout.WEST);
		p11.add(jtfInsert, BorderLayout.CENTER);
		p11.add(jbtInsert, BorderLayout.EAST);
		
		/** Delete + Others
		--------------------------------- */
		JPanel p121 = new JPanel(new GridLayout(1, 2, 10, 5));
		p121.add(jbtDeleteHead);
		p121.add(jbtDeleteTail);
		
		JPanel p122 = new JPanel(new GridLayout(1, 2, 10, 5));
		p122.add(jbtClearSLL);
		p122.add(jbtPrintAll);
		
		JPanel p12 =new JPanel(new FlowLayout(5));
		p12.add(p121);
		p12.add(p122);
		
		/** Search
		--------------------------------- */
		JPanel p131 = new JPanel(new GridLayout(1, 3, 10, 5));
		p131.add(jlSearch);
		p131.add(jtfSearch);
		p131.add(jbtSearch);
		 
		JPanel p13 = new JPanel(new BorderLayout(10, 5));
		
		// Set the jtfSearchResult
		jtfSearchResult.setEditable(false);
		jtfSearchResult.setBackground(Color.WHITE);
		
		p13.add(p131, BorderLayout.WEST);
		p13.add(jtfSearchResult, BorderLayout.CENTER);
		
		JPanel p1 = new JPanel(new GridLayout(3, 1, 10, 5));
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		p1.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		/** Process
		--------------------------------- */
		JPanel p2 = new JPanel(new BorderLayout(5, 5));
		
		// Create and set the scrollbars
		JScrollPane jspProcess = new JScrollPane(jtaProcess);
		jspProcess.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspProcess.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspProcess.setVisible(true);
		
		// Set the jtaProcess
		jtaProcess.setEditable(false);
		
		p2.add(jlProcess, BorderLayout.NORTH);
		p2.add(jspProcess, BorderLayout.CENTER);
		p2.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		/** Set the Frame
		--------------------------------- */
		setLayout(new BorderLayout());
		setSize(400, 350);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
	} // End of the init method
	
	/////////////////////////////////////////////////////////////	
	
	/** Register the Action Listeners When Start
	========================================================= */
	public void start() {
		jbtInsert.addActionListener(this);
		jbtDeleteHead.addActionListener(this);
		jbtDeleteTail.addActionListener(this);
		jbtClearSLL.addActionListener(this);
		jbtPrintAll.addActionListener(this);
		jbtSearch.addActionListener(this);
	} // End of the start method
	
	/////////////////////////////////////////////////////////////
	
	/** Deregister the Action Listeners When Stop
	========================================================= */
	public void stop() {
		jbtInsert.addActionListener(null);
		jbtDeleteHead.addActionListener(null);
		jbtDeleteTail.addActionListener(null);
		jbtClearSLL.addActionListener(null);
		jbtPrintAll.addActionListener(null);
		jbtSearch.addActionListener(null);
	} // End of the stop method
	
	/////////////////////////////////////////////////////////////
	
	/** Actions for the Buttons
	========================================================= */
	public void actionPerformed(ActionEvent e) {
		/** Insert
		--------------------------------- */
		if (e.getSource() == jbtInsert) {
			try {
				/** Add to head */
				if(jcboInsertAt.getSelectedIndex() == 0) {
					list.addToHead(Integer.parseInt(jtfInsert.getText()));
					jtaProcess.append("插入" + jtfInsert.getText() + "至開頭\n"); // update the jtaProcess
				}
				/** Add to tail */
				else {
					list.addToTail(Integer.parseInt(jtfInsert.getText()));
					jtaProcess.append("插入" + jtfInsert.getText() + "至尾端\n"); // update the jtaProcess
				}
			} // End of try
			catch(java.lang.NumberFormatException nfe) {
				// Error message for invalid input
				JOptionPane.showMessageDialog(null, "請輸入整數。", "錯誤", JOptionPane.ERROR_MESSAGE);
			} // End of catch
	    } // End of the events of the jbtInsert
		
		/** Delete
		--------------------------------- */
		/** Delete from head */
		if (e.getSource() == jbtDeleteHead) {
			if(list.isEmpty()) // if the list is empty
				jtaProcess.append("Empty List, 無法刪除開頭\n"); // update the jtaProcess
			else {
				int deleted = list.deleteFromHead();
				jtaProcess.append("從開頭刪除" + deleted + "\n"); // update the jtaProcess
			}
	    } // End of the events of the jbtDeleteHead
		
		/** Delete from tail */
		if (e.getSource() == jbtDeleteTail) {
			if(list.isEmpty()) // if the list is empty
				jtaProcess.append("Empty List, 無法刪除尾端\n"); // update the jtaProcess
			else {
				int deleted = list.deleteFromTail();
				jtaProcess.append("從尾端刪除" + deleted + "\n"); // update the jtaProcess
			}
	    } // End of the events of the jbtDeleteTail
		
		/** Others
		--------------------------------- */
		/** Clear the list */
		if (e.getSource() == jbtClearSLL) {
			jtaProcess.append("Clear SSL.\n"); // update the jtaProcess
			list.clear();
	    } // End of the events of the jbtClearSLL
		
		/** Print the List*/
		if (e.getSource() == jbtPrintAll) {
			jtaProcess.append("Print all: "); // update the jtaProcess
			jtaProcess.append(list.print() + "\n"); // update the jtaProcess
	    } // End of the events of the jbtPrintAll
		
		/** Search
		--------------------------------- */
		if (e.getSource() == jbtSearch) {
			jtaProcess.append("搜尋" + jtfSearch.getText() + "\n"); // update the jtaProcess
			
			try {	
				int index = list.indexOf(Integer.parseInt(jtfSearch.getText()));
				if(index == -1) // if no results found
					jtfSearchResult.setText("找不到" + jtfSearch.getText());
				else // show the index of the first result found
					jtfSearchResult.setText("在第" + index + "個Node");
			} // End of try
			catch(java.lang.NumberFormatException nfe) {
				// Error message for invalid input
				JOptionPane.showMessageDialog(null, "請輸入整數。", "錯誤", JOptionPane.ERROR_MESSAGE);
			} // End of catch
	    } // End of the events of the jbtSearch
	} // End of the actionPerformed method
}
