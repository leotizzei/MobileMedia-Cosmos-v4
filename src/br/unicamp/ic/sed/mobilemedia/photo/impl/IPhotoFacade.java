
package br.unicamp.ic.sed.mobilemedia.photo.impl;

import javax.microedition.lcdui.Command;
import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.photo.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.photo.spec.prov.IPhoto;
import br.unicamp.ic.sed.mobilemedia.photo.spec.req.IMobileResources;

class IPhotoFacade implements IPhoto{

	private MIDlet midlet;

	private PhotoController photoController;

	private PhotoListController photoListController;


	
	private MIDlet getMidlet() {
		if( this.midlet == null){
			IManager manager = ComponentFactory.createInstance();
			IMobileResources mobileResources = (IMobileResources) manager.getRequiredInterface("IMobileResources");
			this.midlet = mobileResources.getMainMIDlet();
		}
		return midlet;
	}


	private PhotoController getPhotoController() {
		if( this.photoController == null){
			MIDlet midlet = this.getMidlet();
			this.photoController = new PhotoController( midlet );
		}

		return this.photoController;
	}


	private PhotoListController getPhotoListController() {
		if( this.photoListController == null){
			MIDlet midlet = this.getMidlet();
			this.photoListController = new PhotoListController( midlet );
		}
		return photoListController;
	}


	

	public boolean postCommand(Command c) {
	
		PhotoController photoController = this.getPhotoController();
		PhotoListController photoListController = this.getPhotoListController();

		photoController.setNextController(photoListController);
	
		return photoController.postCommand(c);

	}

}