package com.services;

import java.awt.Color;
import java.awt.Dimension;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import javax.swing.JPanel;

import com.service.InterfaceSujetDiscussion;


public class IHMClientRMI  extends JFrame  {
	public JButton envoyer;
	public JTextArea zoneAffichage;
	public JTextArea zoneText;
	public JPanel panneau;
	private InterfaceSujetDiscussion chatServeur = null;
	private String name = null;
	private String text;


	public IHMClientRMI() throws RemoteException {
		ControleurClientRMI controlleur = new ControleurClientRMI(" ",chatServeur,this);
		
		envoyer = new JButton("Envoyer");
		zoneAffichage = new JTextArea();
		zoneAffichage.setPreferredSize(new Dimension(200, 200));
		zoneText = new JTextArea();
		zoneText.setPreferredSize(new Dimension(100, 60));
		panneau = new JPanel();
		zoneAffichage.setText(text);
		envoyer.addActionListener(controlleur);
		zoneAffichage.setEditable(false);
		zoneAffichage.setBackground(Color.magenta);
		panneau.add(zoneAffichage);
		panneau.add(zoneText);
		panneau.add(envoyer);
		this.add(panneau);
		setPreferredSize(new Dimension(300, 300));
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}




}
