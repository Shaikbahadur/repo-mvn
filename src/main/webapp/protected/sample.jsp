<%--
  #%L
  learn
  %%
  Copyright (C) 2016 Emory University
  %%
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  
       http://www.apache.org/licenses/LICENSE-2.0
  
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  #L%
  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tlds/function.tld" prefix="myfn" %>

<template:insert template="/templates/eureka_main.jsp">
	<template:content name="content">
            <h3>Webapp Sample Page</h3>
            <form id="theform">
                <div class="panel with-nav-tabs panel-default">
                       <textarea id="printmessage" name="printmessage"  style="width: 100%; height: 100%; overflow: auto">test </textarea>
                 </div>
                <button type="submit" class="btn btn-default" id="printButton" name="printButton">Print Message</button>
            </form>
        <script type="text/javascript">
        $(document).ready(function () {
            $('#theform').submit(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/proxy-resource/test"
                }).done(function (data) {
                    $('#printmessage').val(data);
                    $('#printmessage').show();
                }).fail(function (jqXHR) {
                     $('#printmessage').html('Sorry! No Data from the server');
                     $('#printmessage').show();
                });
                return false;
            });
            });

        </script>
  </template:content>

  </template:insert>
