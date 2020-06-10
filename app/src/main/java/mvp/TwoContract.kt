package mvp

interface TwoContract {

    interface View {

        fun showData(data: String)

        fun detectVisible() : Boolean
    }

    interface Presenter {

        fun getApiData()
    }


}