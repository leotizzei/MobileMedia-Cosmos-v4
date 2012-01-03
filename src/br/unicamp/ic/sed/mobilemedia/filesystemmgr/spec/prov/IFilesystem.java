package br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov;

import javax.microedition.lcdui.Image;



import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.main.spec.prov.IImageData;

/**
 * In MobileMedia-Cosmos-v4, it was exchanged the usage of the datatype ImageData by the interface IImageData
 * that is implemented by the ImageData datatype.
 * 
 *
 */
public interface IFilesystem{

	// #ifdef includeCopyPhoto
	/**
	 * Added in MobileMedia-Cosmos-OO-v4 
	 * 
	 */
	public void addImageData(String photoName, IImageData imageData, String albumName) throws InvalidImageDataException, PersistenceMechanismException;
	// #endif 
	
	public void addNewPhotoToAlbum ( String imageName, String imagePath, String albumName ) throws InvalidImageDataException, PersistenceMechanismException; 
	
	public void createNewPhotoAlbum ( String albumName ) throws PersistenceMechanismException, InvalidPhotoAlbumNameException; 
	
	public void deleteImage ( String imageName, String albumName ) throws PersistenceMechanismException, ImageNotFoundException; 
	
	public void deletePhotoAlbum ( String albumName ) throws PersistenceMechanismException; 
	
	public String[] getAlbumNames (  ); 
	
	public Image getImageFromRecordStore ( String albumName, String imageName ) throws ImageNotFoundException, PersistenceMechanismException; 
 
	public IImageData getImageInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference;
	
	public IImageData[] getImages( String albumName )throws UnavailablePhotoAlbumException;
	
	public void resetImageData (  ) throws PersistenceMechanismException;
	
	public void updateImageInfo( IImageData velhoID , IImageData novoID ) throws InvalidImageDataException, PersistenceMechanismException;
}