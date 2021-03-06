<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Body start -->
<style>
    #main{
        
        margin-left:0px;
    }
 </style>   
<%
    if (session.getAttribute("customerID") == null) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.sendRedirect("home.action");
    }
%> 

<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            MyFashionMarketer
            <span>> 
                Serp Campaign
            </span>
        </h1>
    </div>
</div>

<div id="fade_away" style="color:#FF0000;">
    <s:actionmessage />
    <s:actionerror />
</div>

<!-- widget grid -->
<section id="widget-grid" class="">

    <!-- START ROW -->
    <div class="row">

        <!-- NEW COL START -->
        <article class="col-sm-12 col-md-12 col-lg-12">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
                <!-- widget options:
                usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

                data-widget-colorbutton="false"
                data-widget-editbutton="false"
                data-widget-togglebutton="false"
                data-widget-deletebutton="false"
                data-widget-fullscreenbutton="false"
                data-widget-custombutton="false"
                data-widget-collapsed="true"
                data-widget-sortable="false"

                -->
                <header>
                    <span class="widget-icon"> <i class="fa fa-clock-o"></i> </span>
                    <h2>Keywords Up</h2>
                </header>

                <s:if test="%{getRankComparision().isEmpty()}"> 

                </s:if>
                <s:else>
                    <!-- widget div-->
                    <div>
                        <!-- start row -->
                        <div class="row">

                            <div class="col-sm-12 col-md-12 col-lg-12">

                                <div class="well">

                                    <div class="row">
                                        <s:iterator value="rankComparision">
                                            <div class="col-md-offset-1 col-sm-2">

                                                <div class="btn green-seagreen text-center">
                                                    <h5>Top 5</h5>
                                                    <code><s:property value="keywordsRankBelow5" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="btn blue-light text-center">
                                                    <h5>Top 10</h5>
                                                    <code><s:property value="keywordsRankBelow10" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="btn red-flamingo text-center">
                                                    <h5>Top 20</h5>
                                                    <code><s:property value="keywordsRankBelow20" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="btn blue-hoki text-center">
                                                    <h5>Top 30</h5>
                                                    <code><s:property value="keywordsRankBelow30" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="btn yellow-gold text-center">
                                                    <h5>Top 100</h5>
                                                    <code><s:property value="keywordsRankBelow100" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>
                                        </s:iterator>

                                    </div>

                                </div>

                            </div>

                        </div>
                        <!-- end row -->

                    </div>
                    <!-- end widget div -->
                </s:else>

            </div>
            <!-- end widget -->

        </article>
        <!-- END COL -->

    </div>

    <!-- END ROW -->

    <!-- START ROW -->

    <div class="row">

        <!-- NEW COL START -->
        <article class="col-sm-12 col-md-12 col-lg-12">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-1" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
                <!-- widget options:
                usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

                data-widget-colorbutton="false"
                data-widget-editbutton="false"
                data-widget-togglebutton="false"
                data-widget-deletebutton="false"
                data-widget-fullscreenbutton="false"
                data-widget-custombutton="false"
                data-widget-collapsed="true"
                data-widget-sortable="false"

                -->
                <header>
                    <span class="widget-icon"> <i class="fa fa-edit"></i> </span>
                    <h2>Serp Campaigns</h2>
                    <form action="searchSerpsCampaign.action" name="searchCampaign" id="searchCampaign" method="get">
                        <div class="widget-toolbar">
                            <span>Using (<s:property value="activeKeywordsCount" />/<s:property value="allowedKeywordsCount" />) Keywords</span>
                        </div>
                        <div class="widget-toolbar">
                            <!-- add: non-hidden - to disable auto hide -->
                            <div class="btn-group">
                                <input type="text" hidden name="searchSerpsCampaign" value="Search Campaign" autocomplete="off" id="serpcamp"/>
                                <button class="btn dropdown-toggle btn-xs btn-default" data-toggle="dropdown" id="dropdownserps">
                                    Search Campaign <i class="fa fa-caret-down"></i>
                                </button>
                                <ul class="dropdown-menu js-status-update pull-right">
                                    <s:iterator value="lstCampaignsSearch" status="temp">
                                        <s:if test="%{campaignType.equals('serp')}">
                                            <li>
                                                <a><s:property value="campaign"/></a>
                                            </li> 
                                        </s:if>
                                    </s:iterator>
                                </ul>
                            </div>
                            <button type="submit" class="btn btn-primary btn-xs">
                                <i class="fa fa-search fa-fw"></i>Search
                            </button>
                        </div>
                    </form>

                </header>

                <!-- widget div-->
                <div>

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->
                    <div class="smart-form">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">
                                <s:if test="%{getLstCampaigns().isEmpty()}"> 
                                    <s:form name="campaignDetail" >
                                        <s:hidden name="campaignId" />

                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th><i class="fa fa-institution"></i> Campaign Name</th>
                                                    <th colspan="7">Actions</th>
                                                </tr>
                                            </thead>

                                        </table>
                                    </s:form >
                                </s:if> 
                                <s:else>
                                    <s:form name="campaignDetail" >
                                        <s:hidden name="campaignId" />
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th><i class="fa fa-institution"></i> Campaign Name</th>
                                                    <th colspan="7">Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>		
                                                <s:iterator value="lstCampaigns" status="temp">
                                                    <s:if test="%{campaignType.equals('serp')}">
                                                        <tr>
                                                            <td><a href="serpskeywords.action?campaignId=<s:property value="campaignID"/>"><s:property value="campaign"/></a></td>
                                                            <!--<td><a href="javascript:refreshSerpsCampaign('<s:property value="campaignID"/>', '<s:property value="campaign"/>');" title="Refresh Ranking" id="refreshRank"><i class="fa fa-refresh fa-2x txt-color-blue"></i></a></td>-->
                                                            <td ><a href="#" title="Share Campaign Details" id="share" onclick="copyViewKey('<s:property value="viewKey" />');"><i class="fa fa-share-alt fa-2x" data-toggle="modal" data-target="#viewkeymodal"></i></a></td>
                                                            <td><a href="#" title="Send Campaign Report" onclick="openSerpEmailWindow(<s:property value="campaignID"/>);"><i class="fa fa-envelope fa-2x txt-color-blue" data-toggle="modal" data-target="#serpmailmodal"></i></a></td>
                                                            <td ><a href="generateExcelReport.action?campaignId=<s:property value="campaignID"/>&campaignName=<s:property value="campaign" />" title="Generate Excel Report"><i class="fa fa-file-excel-o fa-2x txt-color-green"></i></a></td>
                                                            <td><a href="generatePDFReport.action?campaignId=<s:property value="campaignID"/>&campaignName=<s:property value="campaign" />" title="Generate PDF Report"><i class="fa fa-file-pdf-o fa-2x txt-color-red"></i></a></td>
                                                            <td ><a href="#" title="Edit Campaign" onclick="openSerpsEditCampaign('<s:property value="campaignID"/>', '<s:property value="campaign"/>');"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
                                                            <td><a href="#" title="Delete Campaign" onclick="openDeleteSerpCampaign('<s:property value="campaignID"/>');"><i class="fa fa-trash-o fa-2x" data-toggle="modal" data-target="#deleteserpmodal"></i></a></td>
                                                        </tr>
                                                    </s:if>
                                                </s:iterator>
                                        </table>
                                    </s:form >
                                </s:else>
                            </div>
                            <!-- end widget content -->
                        </div>
                        <!-- end widget div -->
                        <footer>
                            <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#addserpmodal">
                                Add Serp Campaign
                            </button>                     
                        </footer>
                    </div>
                </div>
                <!-- end widget -->
            </div>
            <!-- end widget ID -->
        </article>
        <!-- END COL -->
    </div>

    <!-- END ROW -->

    <!--Add Campaign Modal -->
    <s:form action="" id="addserpform" onsubmit="return false;" autocomplete="off">
        <div class="modal fade" id="addserpmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add Campaign !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Serp Campaign</h4>
                        <input class="form-control" type="text" name="campaignName" id="campaignName" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="addSerpsCampaign();">Add Campaign</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Edit Campaign Modal -->
    <s:form action="" id="editForm" onsubmit="return false;" autocomplete="off">
        <div class="modal fade" id="editmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Edit !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Update Campaign</h4>
                        <input class="form-control" type="hidden" name="campaignId" id="campaignId" />
                        <input class="form-control" type="text" name="editCampaignName" id="editCampaignName" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="editSerpsCampaign();">Update Campaign</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Delete Campaign Modal -->
    <s:form action="" id="deleteSerpForm" onsubmit="return false;">
        <div class="modal fade" id="deleteserpmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Delete !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Are you sure, you want to delete this? Lost logs cannot be retrieved again.</h4>
                        <input class="form-control" type="hidden" name="campaignId" id="campaignId" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-danger" onclick="deleteSerpsCampaign();">Yes</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Send Mail Modal -->
    <s:form action="" id="serpMailSendForm" onsubmit="return false;">
        <div class="modal fade" id="serpmailmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Send Mail !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Email Address</h4>
                        <input class="form-control" type="hidden" name="campaignId" id="campaignId" />
                        <input class="form-control" type="text" name="emailID" id="emailID" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="sendSerpsCampaignMail();">Send</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Viewkey Modal -->
    <s:form action="" id="viewKeyForm" onsubmit="return false;" autocomplete="off">
        <div class="modal fade" id="viewkeymodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Share Campaign Page !</h4>
                    </div>
                    <div class="modal-body">
                        <a id="viewkey" target="_blank"></a>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

</section>
<!-- end widget grid -->

<script type="text/javascript" >
    var alertMes = "";
    function addSerpsCampaign() {
        var jString = document.addserpform.campaignName.value;
        $.post(
                'ajax/addSerpsCampaign.action',
                {
                    jString: jString
                },
        function(jMessage) {
            alertMes = jMessage.message;
            if (alertMes === "Campaign Value required") {
                window.location = "serps.action";
                document.addserpform.campaignName.focus();
            } else if (alertMes === "Campaign has been created. Please Click on Campaign Name to Add Keywords") {
                window.location = "serps.action";
            } else if (alertMes === "Campaign has been Deleted") {
                window.location = "serps.action";
            } else if (alertMes === "Sorry This Campaign value already exist in Database")
            {
                window.location = "serps.action";
                document.addserpform.campaignName.focus();
            }
            else if (alertMes === "Your Assigned Quota for Number of Campaigns is Full.")
            {
                window.location = "serps.action";
            }
            else if (alertMes === "Campaign Name should be alphanumeric")
            {
                window.location = "serps.action";
            }
        },
                'json');
    }

    function openSerpsEditCampaign(campaignId, campaignName) {

        try {
            document.editForm.campaignId.value = campaignId;
            document.editForm.editCampaignName.value = campaignName;
        } catch (e) {
            alert(e);
        }
    }

    function openSerpEmailWindow(campaignId)
    {
        try {
            document.serpMailSendForm.campaignId.value = campaignId;
            document.serpMailSendForm.emailID.value = '';
        } catch (e)
        {
            alert(e);
        }
    }

    function editSerpsCampaign() {
        try {
            var jString = document.editForm.campaignId.value + ":" + document.editForm.editCampaignName.value;
            if ($("#editCampaignName").val().trim().length === 0)
            {
                alert('Please provide Campaign Name');
                return false;
            }
            $.post(
                    'ajax/editSerpsCampaign.action',
                    {
                        jString: jString
                    },
            function(jMessage) {
                alertMes = jMessage.message;
                window.location = "serps.action";
            },
                    'json');
        } catch (e) {
            alert(e);
        }
    }

    function sendSerpsCampaignMail()
    {
        try {
            var email = document.serpMailSendForm.emailID.value;
            var cID = document.serpMailSendForm.campaignId.value;
            var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            if (email == '') {
                alert('Please provide Email address');
                return false;
            } else {
                if (!filter.test(email)) {
                    alert('Please provide a valid Email address');
                    return false;
                }
                else {
                    var jString = cID + ':' + email;
                    $.post(
                            'ajax/sendserpCampaignReport.action',
                            {
                                jString: jString
                            },
                    function(jMessage) {
                        alertMes = jMessage.message;
                        window.location = "serps.action";
                    },
                            'json');
                }
            }
        } catch (e)
        {
            alert(e);
        }
    }

    function copyViewKey(viewKey)
    {
        try {
            var viewKeyUrl = "tracker.myfashionmarketer.com/myfashion/viewKey.action?key=" + viewKey;
            document.getElementById('viewkey').innerHTML = viewKeyUrl;
            document.getElementById('viewkey').href = viewKeyUrl;
        } catch (e)
        {
            alert(e);
        }
    }

</script>
<script type="text/javascript">
    function openDeleteSerpCampaign(campaignId)
    {
        try {
            document.deleteSerpForm.campaignId.value = campaignId;
        } catch (e) {
            alert(e);
        }
    }

    function deleteSerpsCampaign() {
        var jString = document.deleteSerpForm.campaignId.value;
        $.post(
                'ajax/deleteSerpsCampaign.action',
                {
                    jString: jString
                },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serps.action";
        },
                'json');
    }

    function refreshSerpsCampaign(campaignId, campaignName) {
        var jString = campaignId + ":" + campaignName;
        $.post(
                'ajax/refreshSerpsCampaign.action',
                {
                    jString: jString
                },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serps.action";
        },
                'json');
    }

</script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>

<script type="text/javascript">
    $(".js-status-update a").click(function() {
        var selText = $(this).text();
        var $this = $(this);
        document.getElementById("serpcamp").value = selText;
        $this.parents('.btn-group').find('.dropdown-toggle').html(selText + ' <span class="caret"></span>');
        $this.parents('.dropdown-menu').find('li').removeClass('active');
        $this.parent().addClass('active');
    });
</script>

<script>
    $('#left-panel').css('display','none');
   </script> 