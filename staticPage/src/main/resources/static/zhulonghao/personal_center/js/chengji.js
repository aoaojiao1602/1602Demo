var myChart = echarts.init(document.getElementById('main2'));

var colors = ['#5793f3', '#d14a61', '#675bba'];


var option = {
	color: colors,

	tooltip: {
		trigger: 'none',
		axisPointer: {
			type: 'cross'
		}
	},
	legend: {
		data: ['平均平均', '我的成绩']
	},
	grid: {
		top: 70,
		bottom: 50
	},
	xAxis: [{
			type: 'category',
			axisTick: {
				alignWithLabel: true
			},
			axisLine: {
				onZero: false,
				lineStyle: {
					color: colors[1]
				}
			},
			axisPointer: {
				label: {
					formatter: function(params) {
						return '我的成绩  ' + params.value +
							(params.seriesData.length ? '：' + params.seriesData[0].data : '');
					}
				}
			},
			data: ["2016-1", "2016-2", "2016-3", "2016-4", "2016-5", "2016-6", "2016-7", "2016-8", "2016-9", "2016-10",
				"2016-11", "2016-12"
			]
		},
		{
			type: 'category',
			axisTick: {
				alignWithLabel: true
			},
			axisLine: {
				onZero: false,
				lineStyle: {
					color: colors[0]
				}
			},
			axisPointer: {
				label: {
					formatter: function(params) {
						return '平局成绩  ' + params.value +
							(params.seriesData.length ? '：' + params.seriesData[0].data : '');
					}
				}
			},
			data: ["2016-1", "2016-2", "2016-3", "2016-4", "2016-5", "2016-6", "2016-7", "2016-8", "2016-9", "2016-10",
				"2016-11", "2016-12"
			]
		}
	],
	yAxis: [{
		type: 'value'
	}],
	series: [{
			name: '平均成绩',
			type: 'line',
			xAxisIndex: 1,
			smooth: true,
			data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
		},
		{
			name: '我的成绩',
			type: 'line',
			smooth: true,
			data: [3.9, 5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 46.6, 55.4, 18.4, 10.3, 0.7]
		}
	]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
