<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- 用户信息 -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/img/test.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

    <#-- 搜索框 -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->

    <#-- 生成主菜单 -->
        <ul class="sidebar-menu">
            <li class="header">导航栏</li>
                <@createMenus menus></@createMenus>
        </ul>

    </section>
</aside>

<#macro createMenus rootMenu = []>
    <#if rootMenu??>
        <#list rootMenu as menu>
            <#if (menu.childmenus()?? && menu.childmenus()?size > 0)>
                <li class="treeview">
                    <a href="javascript:void;" data-url="${menu.url()?default("#")}">
                        <i class="fa ${menu.icon()?default("fa-link")}"><span>${menu.name()?default("未定义")}</span></i>
                        <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                    </a>
                    <ul class="treeview-menu">
                                <@createMenus rootMenu=menu.childmenus()></@createMenus>
                    </ul>
                </li>
            <#else>
                <li>
                    <a href="javascript:;" data-url="${menu.url()?default("#")}">
                        <i class="fa ${menu.icon()?default("fa-link")}"><span>${menu.name()?default("未定义")}</span></i>
                    </a>
                </li>
            </#if>
        </#list>
    </#if>
</#macro>