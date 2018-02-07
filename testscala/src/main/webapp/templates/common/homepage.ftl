<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Starter</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/webjars/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/webjars/ionicons/3.0.0/dist/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/webjars/AdminLTE/2.4.2-1/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link rel="stylesheet" href="/webjars/AdminLTE/2.4.2-1/dist/css/skins/skin-blue.min.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

<#-- 顶部导航栏 -->
    <#include "header.ftl" />

<#-- 左侧菜单栏 -->
    <#include "menus.ftl" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Page Header
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->

            <#if menus??>
                <p>---</p>
            <#else >
                <p>mei</p>
            </#if>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            Anything you want
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2018 <a href="#">Company</a>.</strong> All rights reserved.
    </footer>


<#-- 右边侧栏 -->
    <#include "right-sidebar.ftl" />
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<script src="/webjars/jquery/3.3.1/dist/jquery.min.js" type="text/javascript"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="/js/AdminLTE-App.js" type="text/javascript"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->

<script type="text/javascript">
    (function () {
        var menus = $(".sidebar-menu a[data-url]");
        console.info(menus);
    })();
</script>
</body>
</html>
