<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <script>
            (function (i, s, o, g, r, a, m) {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function () {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

            ga('create', 'UA-65722895-1', 'auto');
            ga('send', 'pageview');

        </script>
        <div class="row">
            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
                <h1 class="page-title txt-color-blueDark">
                    <i class="fa fa-bolt fa-fw "></i>
                    Globustracker
                    <span>>
                        Google Analytics
                    </span>
                </h1>
            </div>
        </div>


        <!-- widget grid -->
        <section id="widget-grid" class="">
            <!-- START ROW -->
            <div class="row">
                <!-- NEW COL START -->
                <article class="col-sm-12 col-md-12 col-lg-12">

                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <div class="row">
                                <div id="embed-api-auth-container"></div>
                                <div class="col-md-5 col-md-offset-1 well text-center" style="min-height:300px;">
                                    <div style="width: 50%;padding-left: 25% "  ><div id="chart-container"></div></div>
                                </div>
                                <div class="col-md-5 well text-center" style="min-height:300px; margin-left: 3%;">
                                    <div style="width: 50%;padding-left: 25%"  ><div id="chart-container1"></div></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5 col-md-offset-1 well text-center" style="min-height:300px;">
                                    <div style="width: 50%;padding-left: 25%"  ><div id="chart-container2"></div></div>
                                </div>
                                <div class="col-md-5 well text-center" style="min-height:300px; margin-left: 3%;">
                                    <div style="width: 50%;padding-left: 25%"  ><div id="chart-container3"></div></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- END COL -->
            </div>
            <!-- END ROW -->
        </section>
        <!-- end widget grid -->

        <!-- SCRIPTS ON PAGE EVENT -->
        
        
        <script>
            (function (w, d, s, g, js, fs) {
                g = w.gapi || (w.gapi = {});
                g.analytics = {q: [], ready: function (f) {
                        this.q.push(f);
                    }};
                js = d.createElement(s);
                fs = d.getElementsByTagName(s)[0];
                js.src = 'https://apis.google.com/js/platform.js';
                fs.parentNode.insertBefore(js, fs);
                js.onload = function () {
                    g.load('analytics');
                };
            }(window, document, 'script'));
        </script>
        <script>

            gapi.analytics.ready(function () {

                /**
                 * Authorize the user immediately if the user has already granted access.
                 * If no access has been created, render an authorize button inside the
                 * element with the ID "embed-api-auth-container".
                 */
                gapi.analytics.auth.authorize({
                    container: 'embed-api-auth-container',
                    clientid: '335469395184-5qd9putqhbefup0i335ba3dkh227tdd5.apps.googleusercontent.com'
                });


                /**
                 * Create a new ViewSelector instance to be rendered inside of an
                 * element with the id "view-selector-container".
                 */
                var viewSelector = new gapi.analytics.ViewSelector({
                    container: 'view-selector-container'
                });

                // Render the view selector to the page.
                viewSelector.execute();


                /**
                 * Create a new DataChart instance with the given query parameters
                 * and Google chart options. It will be rendered inside an element
                 * with the id "chart-container".
                 */
                var dataChart = new gapi.analytics.googleCharts.DataChart({
                    query: {
                        metrics: 'ga:pageviews',
                        dimensions: 'ga:date',
                        'start-date': '30daysAgo',
                        'end-date': 'yesterday'
                    },
                    chart: {
                        container: 'chart-container',
                        type: 'LINE',
                        options: {
                            width: '100%'
                        }
                    }
                });

                var dataChart1 = new gapi.analytics.googleCharts.DataChart({
                    query: {
                        metrics: 'ga:bounceRate',
                        dimensions: 'ga:date',
                        'start-date': '30daysAgo',
                        'end-date': 'yesterday'
                    },
                    chart: {
                        container: 'chart-container1',
                        type: 'LINE',
                        options: {
                            width: '100%'
                        }
                    }
                });

                var dataChart2 = new gapi.analytics.googleCharts.DataChart({
                    query: {
                        metrics: 'ga:percentNewVisits',
                        dimensions: 'ga:date',
                        'start-date': '30daysAgo',
                        'end-date': 'yesterday'
                    },
                    chart: {
                        container: 'chart-container2',
                        type: 'LINE',
                        options: {
                            width: '100%'
                        }
                    }
                });
				
				 var dataChart3 = new gapi.analytics.googleCharts.DataChart({
                    query: {
                        metrics: 'ga:users',
                        dimensions: 'ga:date',
                        'start-date': '30daysAgo',
                        'end-date': 'yesterday'
                    },
                    chart: {
                        container: 'chart-container3',
                        type: 'LINE',
                        options: {
                            width: '100%'
                        }
                    }
                });
				
				
				 var dataChart4 = new gapi.analytics.googleCharts.DataChart({
                    query: {
                        metrics: 'ga:visits',
                        dimensions: 'ga:date',
                        'start-date': '30daysAgo',
                        'end-date': 'yesterday'
                    },
                    chart: {
                        container: 'chart-container4',
                        type: 'LINE',
                        options: {
                            width: '100%'
                        }
                    }
                });
                /**
                 * Render the dataChart on the page whenever a new view is selected.
                 */
                viewSelector.on('change', function (ids) {
                    dataChart.set({query: {ids: ids}}).execute();
                    setTimeout(function () {
                        var obj1 = $('#chart-container').children();
                        var obj2 = $(obj1).children();
                        var obj3 = $(obj2).children();
                        var obj4 = $(obj3).children();
                        var obj5 = $(obj4).children();
                        var obj6 = $(obj5).children()[3];
                        var obj7 = $(obj6).children()[1];
                        var line = $(obj7).children()[3];
                        var finalline = $(line).children()[0];
                        var forcircle = $(obj6).children()[2];
                        var circles = $(forcircle).children();
                        $(finalline).attr('stroke', '#058DC7');
                        $.each(circles, function (i, a) {
                            $(a).attr('fill', '#058DC7');
                        });
                    }, 3000);
                });

                viewSelector.on('change', function (ids) {
                    dataChart1.set({query: {ids: ids}}).execute();
                    setTimeout(function () {
                        var obj1 = $('#chart-container1').children();
                        var obj2 = $(obj1).children();
                        var obj3 = $(obj2).children();
                        var obj4 = $(obj3).children();
                        var obj5 = $(obj4).children();
                        var obj6 = $(obj5).children()[3];
                        var obj7 = $(obj6).children()[1];
                        var line = $(obj7).children()[3];
                        var finalline = $(line).children()[0];
                        var forcircle = $(obj6).children()[2];
                        var circles = $(forcircle).children();
                        $(finalline).attr('stroke', '#058DC7');
                        $.each(circles, function (i, a) {
                            $(a).attr('fill', '#058DC7');
                        });
                    }, 3000);
                });

                viewSelector.on('change', function (ids) {
                    dataChart2.set({query: {ids: ids}}).execute();
                    setTimeout(function () {
                        var obj1 = $('#chart-container2').children();
                        var obj2 = $(obj1).children();
                        var obj3 = $(obj2).children();
                        var obj4 = $(obj3).children();
                        var obj5 = $(obj4).children();
                        var obj6 = $(obj5).children()[3];
                        var obj7 = $(obj6).children()[1];
                        var line = $(obj7).children()[3];
                        var finalline = $(line).children()[0];
                        var forcircle = $(obj6).children()[2];
                        var circles = $(forcircle).children();
                        $(finalline).attr('stroke', '#058DC7');
                        $.each(circles, function (i, a) {
                            $(a).attr('fill', '#058DC7');
                        });
                    }, 3000);
                });
				
				
				viewSelector.on('change', function (ids) {
                    dataChart3.set({query: {ids: ids}}).execute();
                    setTimeout(function () {
                        var obj1 = $('#chart-container3').children();
                        var obj2 = $(obj1).children();
                        var obj3 = $(obj2).children();
                        var obj4 = $(obj3).children();
                        var obj5 = $(obj4).children();
                        var obj6 = $(obj5).children()[3];
                        var obj7 = $(obj6).children()[1];
                        var line = $(obj7).children()[3];
                        var finalline = $(line).children()[0];
                        var forcircle = $(obj6).children()[2];
                        var circles = $(forcircle).children();
                        $(finalline).attr('stroke', '#058DC7');
                        $.each(circles, function (i, a) {
                            $(a).attr('fill', '#058DC7');
                        });
                    }, 3000);
                });
				
				viewSelector.on('change', function (ids) {
                    dataChart4.set({query: {ids: ids}}).execute();
                    setTimeout(function () {
                        var obj1 = $('#chart-container4').children();
                        var obj2 = $(obj1).children();
                        var obj3 = $(obj2).children();
                        var obj4 = $(obj3).children();
                        var obj5 = $(obj4).children();
                        var obj6 = $(obj5).children()[3];
                        var obj7 = $(obj6).children()[1];
                        var line = $(obj7).children()[3];
                        var finalline = $(line).children()[0];
                        var forcircle = $(obj6).children()[2];
                        var circles = $(forcircle).children();
                        $(finalline).attr('stroke', '#058DC7');
                        $.each(circles, function (i, a) {
                            $(a).attr('fill', '#058DC7');
                        });
                    }, 3000);
                });
				
				
				
				
				
				

            });
						
			

            $(document).ready(function () {

                var obj1 = $('#chart-container').children();
                var obj2 = $(obj1).children();
                var obj3 = $(obj2).children();
                var obj4 = $(obj3).children();
                var obj5 = $(obj4).children();
                var obj6 = $(obj5).children()[3];
                var obj7 = $(obj6).children()[1];
                var line = $(obj7).children()[3];
                var finalline = $(line).children()[0];
                var forcircle = $(obj6).children()[2];
                var circles = $(forcircle).children();
                $(finalline).attr('stroke', '#058DC7');
                $.each(circles, function (i, a) {
                    $(a).attr('fill', '#058DC7');
                });

            });
        </script>


   
