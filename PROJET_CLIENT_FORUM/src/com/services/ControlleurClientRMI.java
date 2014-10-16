package com.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


import com.service.InterfaceAffichageClient;
import com.service.InterfaceSujetDiscussion;


class ControleurClientRMI extends UnicastRemoteObject implements ActionListener, InterfaceAffichageClient, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InterfaceSujetDiscussion chatServeur= null;
	private String name = null;
	private ClientRMI client;
	private IHMClientRMI ihm = null;
	
	

	public ControleurClientRMI(String name , InterfaceSujetDiscussion chatServeur) throws RemoteException {
		this.name = name;
		this.chatServeur = chatServeur;
		chatServeur.inscription(this);

	}
	public ControleurClientRMI(String name,InterfaceSujetDiscussion chatServeur,IHMClientRMI ihm) throws RemoteException {
		this.name = name;
		this.chatServeur = chatServeur;
		this.ihm= ihm;
	
}

	@Override
	public void actionPerformed(ActionEvent e) {		
	}

	@Override
	public void affiche(String message) throws RemoteException {
		System.out.println(message);
		client.ihm.zoneAffichage.append(message + '\n');
	
	}
	
	public void run(){
		Scanner scanner =new Scanner(System.in);
		String message;

	
		while(true){
			
			message = scanner.nextLine();
			
			try {
				chatServeur.diffuse(name + " : "+ message);
				client.ihm.zoneAffichage.append(message + '\n');
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
