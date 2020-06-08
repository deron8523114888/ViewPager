package bean

data class DataBeanThree(

    var contentType: String,
    var isImage: String,
    var data: ArrayList<dataThree>

)


data class dataThree(

    var subject: String,
    var caseName: String,
    var updatedDate: String,
    var themeCategories: ArrayList<String>,
    var orgName: String

)