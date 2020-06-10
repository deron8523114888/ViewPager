package mvp

interface ThreeContract {

    interface View {
        fun showData(data: String)

        fun detectVisible() : Boolean
    }

    interface Presenter {

        fun getApiData()

    }


}