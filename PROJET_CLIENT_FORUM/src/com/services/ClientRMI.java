package com.services;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;

import com.service.InterfaceSujetDiscussion;


public class ClientRMI {
	private static String message;
	public static IHMClientRMI ihm;
	public static void main(String[] args) throws MalformedURLException{
		try {
			String nom = "FORUM";
			InterfaceSujetDiscussion serveur = (InterfaceSujetDiscussion) Naming.lookup(nom);
			
			ihm = new IHMClientRMI();
			ihm.setVisible(true);
			ihm.setSize(300, 300);
			ihm.setTitle("hello");
			new Thread(new ControleurClientRMI("client",serveur)).start();
		}
		catch (NotBoundException e) {
			System.out.println("le serveur n'est pas enregistre");
		}
		catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
	}
	public static String getMessage() {
		return message;
	}
	@SuppressWarnings("static-access")
	public void setMessage(String message) {
		this.message = message;
	}

	}




