# Vendor Profit
---

Design Document

Group Members: Cheveaux Beasley, Chris Meyer, and John Summers

## Introduction

Our vision for this group project is to have an online inventory system that can be interacted with by users through sales and returns.  


## Storyboard

 
[StoryboardDraft.pptx](https://github.com/meyer3cj/inventorysystem-entappdev/files/5252341/StoryboardDraft.pptx)

## Requirements
Our audience is a business that sells certain items.  
### - As a user I want to keep track of the inventory of the company so I know what items need to be purchased again  

-	Given: When product data is available. 
-	When: Products are entered into the system, ‘view inventory’ button is clicked.
-	Then: A grid of products are displayed.

### - As a user I want to keep track of purchases so I know how many purchases we have made  

- Given: When purchase data is available.
-	When: When orders are entered into the system, ‘view purchases’ button is clicked.
-	Then: A grid of purchases are displayed.

### - As a user I want to keep track of returns so I know what has been return 

-	Given: When return of items data is available. 
-	When: When items are getting returned, ‘view returns’ button is clicked.
-	Then: A grid of returned items is displayed.  

### -	As a user I want to monitor what the profits are so I know how much we are making.  

-	Given: When profits data is available. 
-	When: When profits are calculated, ‘view profits’ button is clicked.
-	Then: Profit data is displayed.  

### -	As a user I want to communicate what needs to be purchased and discontinued  

-	Given: Purchase and item data is available. 
-	When: When items are being returned more than purchased, ‘discontinue item’ button is clicked
-	Then: A discontinue flag is sent to the item and the item is discontinued.

## Class Diagram  

![Screenshot 2020-09-20 141814](https://user-images.githubusercontent.com/59851587/93718774-3d22d280-fb4c-11ea-81e4-ab25e43f450a.png)

## JSON Schema  
{    
"type" : "object",   
"properties" : {   
"productid" : {  
"type" : "integer"  
},  
"productname" : {  
"type" : "string"  
}, 
"proudtnumber" : {  
"type" : "string"  
},  
"vendorID" : {  
"type" : "integer"  
},  
"productdesc" : {  
"type" : "string"  
  }  
 }  
}
## Scrum Roles  
- Scrum Master/ Product owner/Github Moderator: Chris Meyer  
- UI Specialist: Cheveaux Beasley  
- Business logic and  Persistence Specialist: John Summers
## Github Link  
- https://github.com/meyer3cj/inventorysystem-entappdev
## Team Communication
We were unable to create a team through teams, but were able to chat through teams both verbally and textually. We meet at least once a week, usually Sunday at noon, to discuss progress. 










