/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
    config.filebrowserImageBrowseUrl = '/ckfinder/ckfinder.html?type=Images';

    config.filebrowserFlashBrowseUrl = '/ckfinder/ckfinder.html?type=Flash';


    config.filebrowserUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';

    config.filebrowserImageUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';

    config.filebrowserFlashUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
    config.extraPlugins='cloudservices';


};
