$(function () {

    $("#zoom").elevateZoom({ constrainType: "height", constrainSize: 274, zoomType: "lens", containLensZoom: true, gallery: 'gallery_01', cursor: 'pointer', galleryActiveClass: "active" });

    //pass the images to Fancybox
    $("#zoom").bind("click", function (e) {
        var ez = $('#zoom_03').data('elevateZoom');
        $.fancybox(ez.getGalleryList());
        return false;
    });






});