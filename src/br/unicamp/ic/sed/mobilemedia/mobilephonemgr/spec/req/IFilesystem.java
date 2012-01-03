package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req;

import javax.microedition.lcdui.Image;



import br.unicamp.ic.sed.mobilemedia.main.spec.prov.IImageData;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.UnavailablePhotoAlbumException;

public interface IFilesystem{

	public void addNewPhotoToAlbum ( String imageName, String imagePath, String albumName ) throws InvalidImageDataException, PersistenceMechanismException; 
	
	public void deleteImage ( String imageName, String albumName ) throws PersistenceMechanismException, ImageNotFoundException; 
	
	public Image getImageFromRecordStore ( String albumName, String imageName ) throws ImageNotFoundException, PersistenceMechanismException; 
	
	public String[] getAlbumNames (  ); 
	
	public void resetImageData (  ) throws PersistenceMechanismException; 
	
	public void createNewPhotoAlbum ( String albumName ) throws PersistenceMechanismException, InvalidPhotoAlbumNameException; 
	
	public void deletePhotoAlbum ( String albumName ) throws PersistenceMechanismException; 

	public IImageData getImageInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference;

	public void updateImageInfo( IImageData velhoID , IImageData novoID ) throws InvalidImageDataException, PersistenceMechanismException;
		 
	public IImageData[] getImages( String albumName )throws UnavailablePhotoAlbumException;
	
	// #ifdef includeCopyPhoto
	/*
	 * Added in MobileMedia-Cosmos-OO-v4 
	 * 
	 */
	public void addImageData(String photoName, IImageData imageData, String albumName) throws InvalidImageDataException, PersistenceMechanismException;
	// #endif
}