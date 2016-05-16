var data = [
  {
    x: ['Waiting Room', 'Emergency Department', 'General', 'Ward 1', 'Ward 2', 'Ward 3', 'Ward 4'],
    y: [20, 14, 23, 25, 35, 64, 23],
    type: 'bar'
  }
];

Plotly.newPlot('wardUsage', data);