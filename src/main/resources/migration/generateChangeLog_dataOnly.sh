#!/bin/bash

liquibase --diffTypes="data" --excludeObjects="spatial_ref_sys" generateChangeLog