
<% if (request.isUserInRole("ADMIN")) { %>
	<script>location.href='pages/dashboard/admin/index.jsf';</script>
<% } %>
<% if (request.isUserInRole("USER")) { %>
	<script>location.href='pages/index/index.jsf';</script>
<% } %>
