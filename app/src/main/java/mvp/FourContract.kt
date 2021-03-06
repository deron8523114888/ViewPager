package mvp

interface FourContract {

    interface View {
        fun showData(data: String)

        fun detectVisible() : Boolean
    }

    interface Presenter {

        fun getApiData()

    }


}