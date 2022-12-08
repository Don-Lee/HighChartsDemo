package cn.rjgc.highchartsdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.highsoft.highcharts.common.hichartsclasses.*
import com.highsoft.highcharts.core.HIChartView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chartView = findViewById<View>(R.id.hc) as HIChartView
        val options = HIOptions()
        //隐藏右下角官网地址
        val credits = HICredits()
        credits.enabled = false
        options.credits = credits

        val chart = HIChart();
        chart.setType("column");
        options.setChart(chart);
        val title = HITitle();

        title.setText("UEFA Champions League 2016/17");
        val subtitle = HISubtitle();
        subtitle.setText("Team statistics");
        options.setTitle(title);
        options.setSubtitle(subtitle);

        val hiyAxis = HIYAxis()
        hiyAxis.min = 0
        hiyAxis.title = HITitle()
        hiyAxis.title.text = "Number"
        options.setYAxis(object : java.util.ArrayList<HIYAxis>() {
            init {
                add(hiyAxis)
            }
        })

        val hixAxis = HIXAxis()
        val categories = java.util.ArrayList<String>()
        categories.add("Goals")
        categories.add("Assists")
        categories.add("Shots On Goal")
        categories.add("Shots")

        hixAxis.categories = categories
        options.setXAxis(object : ArrayList<HIXAxis>() {
            init {
                add(hixAxis)
            }
        })

        val tooltip = HITooltip()
        tooltip.headerFormat = "<span style=\"font-size:15px\">{point.key}</span><table>"
        tooltip.pointFormat =
            "<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td>" + "<td style=\"padding:0\"><b>{point.y}</b></td></tr>"
        tooltip.footerFormat = "</talble>"
        tooltip.shared = true
        tooltip.useHTML = true
        options.tooltip = tooltip


        val plotOptions = HIPlotOptions()
        plotOptions.column = HIColumn()
        plotOptions.column.pointPadding = 0.2
        plotOptions.column.borderWidth = 0
        options.plotOptions = plotOptions

        val realMadrid = HIColumn()
        realMadrid.name = "Real Madrid"
        val realMadridData = ArrayList<Any>()
        realMadridData.add(36)
        realMadridData.add(31)
        realMadridData.add(93)
        realMadridData.add(236)
        realMadrid.data = realMadridData

        val juventus = HIColumn()
        juventus.name = "Juventus"
        val juventusData = ArrayList<Any>()
        juventusData.add(22)
        juventusData.add(10)
        juventusData.add(66)
        juventusData.add(178)
        juventus.data = juventusData

        val monaco = HIColumn()
        monaco.name = "Monaco"
        val monacoData = ArrayList<Any>()
        monacoData.add(22)
        monacoData.add(17)
        monacoData.add(56)
        monacoData.add(147)
        monaco.data = monacoData

        val atleticoMadrid = HIColumn()
        atleticoMadrid.name = "Atlético Madrid"
        val atleticoMadridData = ArrayList<Any>()
        atleticoMadridData.add(15)
        atleticoMadridData.add(9)
        atleticoMadridData.add(55)
        atleticoMadridData.add(160)
        atleticoMadrid.data = atleticoMadridData

        val series = java.util.ArrayList<HISeries>()
        series.add(realMadrid)
        series.add(juventus)
        series.add(monaco)
        series.add(atleticoMadrid)

        options.series = series

        chartView.setOptions(options);
    }
}