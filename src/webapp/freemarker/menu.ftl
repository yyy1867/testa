<#macro loadmenusbyroots rootmenus=[] cj=1>
    <#if rootmenus??>
        <#list rootmenus as rootmenu>
        <li class="${(cj==1&&rootmenu.childmenus??)?string('treeview','')}"><a href="#" data-url="${rootmenu.url!"#"}"><i
                class="fa ${(rootmenu.childmenus??)?string(rootmenu.icon!"fa-dashboard",rootmenu.icon!"fa-circle-o")}"></i> ${rootmenu.name!"未命名"}
        <#if rootmenu.childmenus??>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
            </span>
        </#if>
        </a>
        <#if rootmenu.childmenus??>
            <ul class="treeview-menu">
                <@loadmenusbyroots rootmenu.childmenus cj+1></@loadmenusbyroots>
            </ul>
        </#if>
        </li>
        </#list>
    </#if>
</#macro>
<li class="header">导航栏</li>
<li><a href="home.html"><i class="fa fa-dashboard"></i><span>主页</span></a></li>
<@loadmenusbyroots rootmenus 1></@loadmenusbyroots>