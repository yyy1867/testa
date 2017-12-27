<#macro loadmenusbyroots rootmenus=[] cj=1>
    <#if rootmenus??>
        <#list rootmenus as rootmenu>
        <li class="${(cj==1)?string('treeview','')}"><a href="${rootmenu.url!"#"}"><i
                class="fa ${rootmenu.icon!"fa-circle-o"}"></i> ${rootmenu.name!"未命名"}
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