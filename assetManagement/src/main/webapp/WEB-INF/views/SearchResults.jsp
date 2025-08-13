<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.xtg.model.SearchFormModel" %>


	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-8">
						<h2>Search Results</h2>
					</div>



				</div>
				<table class="table table-bordered" id="searchResultsTable">
					<thead>
						<tr id="headings">
							<th>Asset Type</th>
							<th>Memory Details</th>
							<th>Operating System</th>
							<th>Hardware Asset ID</th>
							<th>Serial Number</th>
							<th>Current Status</th>
							<th>AssignedTo</th>
							<th>AssetLocation</th>
							<th>SpareAssetId</th>
						</tr>
					</thead>
					<tbody>
				
						
						
						<%
						
						     if(session.getAttribute("searchResultDb")!=null){
						    	 
						    	 List<SearchFormModel>  list = (List<SearchFormModel>)session.getAttribute("searchResultDb");
						    	 
						    	 for(SearchFormModel result : list){ %>
						    		 
						    		 <tr class="results">
						    		 
						    		 <td><%=result.getAssettype() %>  </td>
						    		 <td><%=result.getMemorydetails() %>  </td>
						    		  <td> <%=result.getOperatingsystem() %> </td>
						    		  <td> <%=result.getHardwareassetid() %> </td>
						    		   <td><%=result.getSerialno() %>  </td>
						    		  <td><%=result.getCurrentstatus() %>  </td>
						    		  <td><%=result.getAssignedto() %>  </td>
						    		  <td><%=result.getAssetloc() %>  </td>
						    		<td><%=result.getSpareassetid() %>  </td>
						    		
						    		</tr>
						    		 
						    		 
						    <%	 }
						    	 
						    	 
						    	 
						     }else if(session.getAttribute("errorMsg")!=null){%>
						    	 
						    	 <tr class="results">
						    	 <td colspan="9">
						    	 <p style="color:red; text-align:center">No Records Exists</p>
						    	 </td></tr>
						    	 
						    <%  }
						     
						
							
								
								
								
								
							

						
						%>
					
					</tbody>
				</table>
			</div>
		</div>
		</div>
