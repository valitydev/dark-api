package dev.vality.dark.api.converter.filestorage;

import dev.vality.file.storage.NewFileResult;
import dev.vality.swag.dark_api.model.FileData;
import dev.vality.swag.dark_api.model.FileDownload;
import dev.vality.swag.dark_api.model.FileUploadData;

public interface FileStorageConverter {

    FileData convertFileData(dev.vality.file.storage.FileData fileData);

    FileUploadData convertFileUploadData(NewFileResult newFile);

    FileDownload convertFileDownload(String generateDownloadUrl);

}
