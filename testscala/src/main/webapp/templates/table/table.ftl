<!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/lib/bootstrap-table/bootstrap-table.min.css">

<#--<div class="content">-->

    <table id="mainDataGrid">
    </table>

    <div id="mainToolBar">
        <button class="btn">测试按钮</button>
    </div>
<#--</div>-->


<script src="/webjars/jquery/3.3.1/dist/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/lib/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/lib/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript">
    (function () {
        $("#mainDataGrid").bootstrapTable({
            url: "/api/tables",
            toolbar:'#mainToolBar',
            // height: 500,
            striped: true,// 斑马线
            responseHandler: parseData,// 格式化数据
            queryParams: loadQueryParment,// 请求的参数
            sidePagination: 'server',// 设置由client端还是server端处理分页
            pagination: true,// 显示分页条
            pageSize: 30,//默认分页条数
            pageList:[10,30,90,180,500,1000,'All'],// 分页信息
            // showFooter: true,
            // showColumns: true,
            // showPaginationSwitch:true,// 显示分页信息按钮
            paginationLoop:false, // 分页是否能无限循环
            escape:true, // 是否转义html
            showRefresh: true,// 刷新按钮
            showToggle: true,// 切换视图按钮
            columns: [
                // {field:"id",title:'编号'},
                {field: "code", title: '编码',sortable:true},
                {field: "name", title: '名称'},
            ]


        });

        function parseData(res) {
            res = {
                rows: res._embedded.mmTables,
                total: res.page.totalElements
            }
            return res;
        }

        function loadQueryParment(params) {
            params = {
                page: params.offset == 0 ? 0 : params.offset / params.limit,
                size: params.limit
            }
            return params;
        }

    })();
</script>

