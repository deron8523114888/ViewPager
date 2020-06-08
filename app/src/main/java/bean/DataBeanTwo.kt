package bean

data class DataBeanTwo(
    var contentType: String,
    var isImage: String,
    var data: ArrayList<dataTwo>
)

data class dataTwo(

    var area: String,
    var village: String,
    var car_licence: String,
    var tirps_name: String,
    var area_name: String,
    var caption: String,
    var today_s: String,
    var today_e: String,
    var estime_s: String,
    var estime_e: String

)