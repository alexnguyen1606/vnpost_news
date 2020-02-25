<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/13/2020
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="page-slider">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <%--<li data-target="#myCarousel" data-slide-to="3"></li>--%>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <%--<div class="item active">--%>
                <%--<img src="/template/images/tet.jpg" alt="Los Angeles" style="width:100%;">--%>
            <%--</div>--%>

            <div class="item active">
                <img src="/template/images/Banner Cong PostGreen.jpg" alt="Chicago" style="width:100%;">
            </div>

            <div class="item">
                <img src="/template/images/BANNER POSTMART 02.jpg" alt="New york" style="width:100%;">
            </div>
            <div class="item">
                <img src="/template/images/Banner New Year 2020.png" alt="" style="width: 100%;">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<div class="row main-service-wrapper">
    <div class="container">
        <div class="col-sm-4">
            <div class="left-pan">
                <h2 class="hidden-xs">Chuyên trang</h2>
                <div class="content-col">
                    <ul>
                        <li><a href="">
                            <div class="clearfix">
                                <div class="col-left col-sm-2 col-xs-2">
                                    <img src="/template/images/Recycle.png" alt="">
                                </div>
                                <div class="col-left col-sm-10 col-xs-10">
                                    <label>Nói không với rác thải nhựa</label>
                                    <span>Bưu điện Việt Nam vì cuộc sống xanh</span>
                                </div>
                            </div>
                        </a></li>
                        <li><a href="">
                            <div class="clearfix">
                                <div class="col-left col-sm-2 col-xs-2">
                                    <img src="/template/images/newspaper.png" alt="">
                                </div>
                                <div class="col-left col-sm-10 col-xs-10">
                                    <label>Tổng hợp báo chí</label>
                                    <span>Tổng hợp báo chí ngành bưu điện</span>
                                </div>
                            </div>
                        </a></li>
                        <li><a href="">
                            <div class="clearfix">
                                <div class="col-left col-sm-2 col-xs-2">
                                    <img src="/template/images/quan-ly-chat-luong.png" alt="">
                                </div>
                                <div class="col-left col-sm-10 col-xs-10">
                                    <label>Quản lý chất lượng</label>
                                    <span>Văn bản quản lý chất lượng dịch vụ</span>
                                </div>
                            </div>
                        </a></li>
                        <li><a href="">
                            <div class="clearfix">
                                <div class="col-left col-sm-2 col-xs-2">
                                    <img src="/template/images/stamp.png" alt="">
                                </div>
                                <div class="col-left col-sm-10 col-xs-10">
                                    <label>Tem bưu chính</label>
                                    <span>Văn bản quản lý tem bưu chính</span>
                                </div>
                            </div>
                        </a></li>
                        <li><a href="">
                            <div class="clearfix">
                                <div class="col-left col-sm-2 col-xs-2">
                                    <img src="/template/images/thi-dua-khen-thuong.png" alt="">
                                </div>
                                <div class="col-left col-sm-10 col-xs-10">
                                    <label>Thi đua khen thưởng</label>
                                    <span>Tổng hợp thông tin thi đua khen thưởng</span>
                                </div>
                            </div>
                        </a></li>
                        <li><a href="">
                            <div class="clearfix">
                                <div class="col-left col-sm-2 col-xs-2">
                                    <img src="/template/images/recruitment.png" alt="">
                                </div>
                                <div class="col-left col-sm-10 col-xs-10">
                                    <label>Văn bản pháp lý</label>
                                    <span>Văn bản pháp lý các thông tin liên quan</span>
                                </div>
                            </div>
                        </a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-8  news-index-col">
            <h2>Tin Tức</h2>
            <div class="content-right">
                <div class="col-sm-6 left">
                    <div class="news-image">
                        <img src="/template/images/ImageCaching.jpg" alt="">
                    </div>
                    <div class="news-title">
                        <a href=""> Giới thiệu bộ tem "TEM TÌNH YÊU”</a>
                    </div>
                    <div class="date">
                        <h5>10/02/2020</h5>
                    </div>
                    <div class="news-description">
                                    <span>
                                        Ngày 14/02/2020, Bộ Thông tin và Truyền thông sẽ phát hành bộ tem “Tem Tình yêu”. Với Bưu điện Việt Nam, mong muốn phát hành bộ tem Tình yêu để qua con tem, ai cũng cảm thấy mình...
                                    </span>
                    </div>
                </div>
                <div class="col-sm-6 right">
                    <div class="row news-item" style="margin-bottom: 50px;">
                        <div class="col-md-4 col-sm-3 news-tumnail">
                            <img src="/template/images/ImageCaching (1).jpg" alt="">
                        </div>
                        <div class="col-md-8 col-sm-9 news-description">
                            <div class="news-title">
                                <a href="">Phát động Chương trình thi đua Phấn đấu hoàn thành vượt mức các chỉ tiêu kế hoạch 2020</a>
                            </div>
                            <div class="date">
                                <h5>10/02/2020</h5>
                            </div>
                        </div>
                    </div>
                    <div class="row news-item" style="margin-bottom: 50px;">
                        <div class="col-md-4 col-sm-3 news-tumnail">
                            <img src="/template/images/ImageCaching (2).jpg" alt="">
                        </div>
                        <div class="col-md-8 col-sm-9 news-description">
                            <div class="news-title">
                                <a href="">Phát động Chương trình thi đua Phấn đấu hoàn thành vượt mức các chỉ tiêu kế hoạch 2020</a>
                            </div>
                            <div class="date">
                                <h5>10/02/2020</h5>
                            </div>
                        </div>
                    </div>
                    <div class="row news-item" style="margin-bottom: 50px;">
                        <div class="col-md-4 col-sm-3 news-tumnail">
                            <img src="/template/images/ImageCaching (13).jpg" alt="">
                        </div>
                        <div class="col-md-8 col-sm-9 news-description">
                            <div class="news-title">
                                <a href="">Phát động Chương trình thi đua Phấn đấu hoàn thành vượt mức các chỉ tiêu kế hoạch 2020</a>
                            </div>
                            <div class="date">
                                <h5>10/02/2020</h5>
                            </div>
                        </div>
                    </div>
                    <div class="row news-item" style="margin-bottom: 50px;">
                        <div class="col-md-4 col-sm-3 news-tumnail">
                            <img src="/template/images/ImageCachin1g.jpg" alt="">
                        </div>
                        <div class="col-md-8 col-sm-9 news-description">
                            <div class="news-title">
                                <a href="">Phát động Chương trình thi đua Phấn đấu hoàn thành vượt mức các chỉ tiêu kế hoạch 2020</a>
                            </div>
                            <div class="date">
                                <h5>10/02/2020</h5>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class=" main-content">
    <div class=" jumbotron">
        <div class="row">
            <div class="col-md-4">
                <div class="thumbnail" style="background-color: #eee;border: none;">
                    <a href="/w3images/nature.jpg" target="_blank">
                        <img src="/template/images/BCCP-quoc-te.png" class="img-circle" alt="Nature" style="width:300px;height: 250px;">
                        <div class="caption">
                            <p>Bưu Chính Chuyển Phát</p>
                        </div>
                    </a>
                    <hr>
                    <div class="thumbnail-down text-center">
                        <p> <a href=""> Bưu chính chuyển phát Trong nước</a></p>
                        <p><a href="">Bưu chính chuyển phát Quốc tế</a></p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="thumbnail" style="background-color: #eee;border: none;">
                    <a href="/w3images/nature.jpg" target="_blank">
                        <img src="/template/images/ImageCaching23.jpg" class="img-circle" alt="Nature" style="width:300px;height: 250px;">
                        <div class="caption">
                            <p>Bưu Chính Chuyển Phát</p>
                        </div>
                    </a>
                    <hr>
                    <div class="thumbnail-down text-center">
                        <p> <a href=""> Bưu chính chuyển phát Trong nước</a></p>
                        <p><a href="">Bưu chính chuyển phát Quốc tế</a></p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="thumbnail" style="background-color: #eee;border: none;">
                    <a href="/w3images/nature.jpg" target="_blank">
                        <img src="/template/images/ImageCaching (1  2).jpg" class="img-circle" alt="Nature" style="width:300px;height: 250px;">
                        <div class="caption">
                            <p>Bưu Chính Chuyển Phát</p>
                        </div>
                    </a>
                    <hr>
                    <div class="thumbnail-down text-center">
                        <p> <a href=""> Bưu chính chuyển phát Trong nước</a></p>
                        <p><a href="">Bưu chính chuyển phát Quốc tế</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-content2">
        <div class="jumbontron">
            <div class="row">
                <div class="container">
                    <div class="col-md-6 home-left">
                        <h2>THƯ VIỆN VIDEO
                        </h2>
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/4F7k36u7G6M" frameborder="0"
                                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        <h4>Để người dân hài lòng với dịch vụ công quốc gia - Phóng sự truyền hình Nhân Dân</h4>
                    </div>
                    <div class="col-md-6 home-right">
                        <h2 class="text-left">MUA SẮM TRỰC TUYẾN</h2>
                        <p class="text-left">Hiện tại chúng tôi có những gian hàng mua sắm online với đầy đủ những sản phẩm tiện ích, đa dạng. Hy vọng sẽ đem đến cho quý khách hàng những trải nghiệm mua sắm mới mẻ nhất. Hãy đến với hệ thống mua sắm trực tuyến của chúng tôi để tìm cho mình những sản phẩm thiết thực nhất.</p>
                        <div class="home-right-down">
                            <div class="home-right-down-item col-sm-4">
                                <a href="">
                                    <img src="/template/images/portmart.jpg" alt="">
                                    <p>Sàn thương mại điện tử POSTMART</p>
                                </a>
                            </div>
                            <div class="home-right-down-item col-sm-4">
                                <a href="">
                                    <img src="/template/images/tet.jpg" alt="">
                                    <p>Lịch Tết</p>
                                </a>
                            </div>
                            <div class="home-right-down-item col-sm-4">
                                <a href="">
                                    <img src="/template/images/data.jpg" alt="">
                                    <p>Data Post</p>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
